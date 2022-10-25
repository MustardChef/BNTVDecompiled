package org.jacoco.agent.p046rt.internal_b0d6a23.asm.commons;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Opcodes;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.InsnList;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.InsnNode;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.JumpInsnNode;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.LabelNode;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.LocalVariableNode;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.LookupSwitchInsnNode;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.MethodNode;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.TableSwitchInsnNode;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.TryCatchBlockNode;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.commons.JSRInlinerAdapter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/commons/JSRInlinerAdapter.class */
public class JSRInlinerAdapter extends MethodNode implements Opcodes {
    private static final boolean LOGGING = false;
    private final Map<LabelNode, BitSet> subroutineHeads;
    private final BitSet mainSubroutine;
    final BitSet dualCitizens;

    public JSRInlinerAdapter(MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
        this(327680, mv, access, name, desc, signature, exceptions);
        if (getClass() != JSRInlinerAdapter.class) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSRInlinerAdapter(int api, MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
        super(api, access, name, desc, signature, exceptions);
        this.subroutineHeads = new HashMap();
        this.mainSubroutine = new BitSet();
        this.dualCitizens = new BitSet();
        this.f10701mv = mv;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.MethodNode, org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitJumpInsn(int opcode, Label lbl) {
        super.visitJumpInsn(opcode, lbl);
        LabelNode ln = ((JumpInsnNode) this.instructions.getLast()).label;
        if (opcode == 168 && !this.subroutineHeads.containsKey(ln)) {
            this.subroutineHeads.put(ln, new BitSet());
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.MethodNode, org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitEnd() {
        if (!this.subroutineHeads.isEmpty()) {
            markSubroutines();
            emitCode();
        }
        if (this.f10701mv != null) {
            accept(this.f10701mv);
        }
    }

    private void markSubroutines() {
        BitSet anyvisited = new BitSet();
        markSubroutineWalk(this.mainSubroutine, 0, anyvisited);
        for (Map.Entry<LabelNode, BitSet> entry : this.subroutineHeads.entrySet()) {
            LabelNode lab = entry.getKey();
            BitSet sub = entry.getValue();
            int index = this.instructions.indexOf(lab);
            markSubroutineWalk(sub, index, anyvisited);
        }
    }

    private void markSubroutineWalk(BitSet sub, int index, BitSet anyvisited) {
        markSubroutineWalkDFS(sub, index, anyvisited);
        boolean loop = true;
        while (loop) {
            loop = false;
            for (TryCatchBlockNode trycatch : this.tryCatchBlocks) {
                int handlerindex = this.instructions.indexOf(trycatch.handler);
                if (!sub.get(handlerindex)) {
                    int startindex = this.instructions.indexOf(trycatch.start);
                    int endindex = this.instructions.indexOf(trycatch.end);
                    int nextbit = sub.nextSetBit(startindex);
                    if (nextbit != -1 && nextbit < endindex) {
                        markSubroutineWalkDFS(sub, handlerindex, anyvisited);
                        loop = true;
                    }
                }
            }
        }
    }

    private void markSubroutineWalkDFS(BitSet sub, int index, BitSet anyvisited) {
        do {
            AbstractInsnNode node = this.instructions.get(index);
            if (sub.get(index)) {
                return;
            }
            sub.set(index);
            if (anyvisited.get(index)) {
                this.dualCitizens.set(index);
            }
            anyvisited.set(index);
            if (node.getType() == 7 && node.getOpcode() != 168) {
                JumpInsnNode jnode = (JumpInsnNode) node;
                int destidx = this.instructions.indexOf(jnode.label);
                markSubroutineWalkDFS(sub, destidx, anyvisited);
            }
            if (node.getType() == 11) {
                TableSwitchInsnNode tsnode = (TableSwitchInsnNode) node;
                int destidx2 = this.instructions.indexOf(tsnode.dflt);
                markSubroutineWalkDFS(sub, destidx2, anyvisited);
                for (int i = tsnode.labels.size() - 1; i >= 0; i--) {
                    LabelNode l = tsnode.labels.get(i);
                    int destidx3 = this.instructions.indexOf(l);
                    markSubroutineWalkDFS(sub, destidx3, anyvisited);
                }
            }
            if (node.getType() == 12) {
                LookupSwitchInsnNode lsnode = (LookupSwitchInsnNode) node;
                int destidx4 = this.instructions.indexOf(lsnode.dflt);
                markSubroutineWalkDFS(sub, destidx4, anyvisited);
                for (int i2 = lsnode.labels.size() - 1; i2 >= 0; i2--) {
                    LabelNode l2 = lsnode.labels.get(i2);
                    int destidx5 = this.instructions.indexOf(l2);
                    markSubroutineWalkDFS(sub, destidx5, anyvisited);
                }
            }
            switch (this.instructions.get(index).getOpcode()) {
                case 167:
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 177:
                case 191:
                    return;
                case 168:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 185:
                case 186:
                case 187:
                case 188:
                case 189:
                case 190:
                default:
                    index++;
                    break;
            }
        } while (index < this.instructions.size());
    }

    private void emitCode() {
        LinkedList<Instantiation> worklist = new LinkedList<>();
        worklist.add(new Instantiation(null, this.mainSubroutine));
        InsnList newInstructions = new InsnList();
        List<TryCatchBlockNode> newTryCatchBlocks = new ArrayList<>();
        List<LocalVariableNode> newLocalVariables = new ArrayList<>();
        while (!worklist.isEmpty()) {
            Instantiation inst = worklist.removeFirst();
            emitSubroutine(inst, worklist, newInstructions, newTryCatchBlocks, newLocalVariables);
        }
        this.instructions = newInstructions;
        this.tryCatchBlocks = newTryCatchBlocks;
        this.localVariables = newLocalVariables;
    }

    private void emitSubroutine(Instantiation instant, List<Instantiation> worklist, InsnList newInstructions, List<TryCatchBlockNode> newTryCatchBlocks, List<LocalVariableNode> newLocalVariables) {
        LabelNode duplbl = null;
        int c = this.instructions.size();
        for (int i = 0; i < c; i++) {
            AbstractInsnNode insn = this.instructions.get(i);
            Instantiation owner = instant.findOwner(i);
            if (insn.getType() == 8) {
                LabelNode ilbl = (LabelNode) insn;
                LabelNode remap = instant.rangeLabel(ilbl);
                if (remap != duplbl) {
                    newInstructions.add(remap);
                    duplbl = remap;
                }
            } else if (owner != instant) {
                continue;
            } else if (insn.getOpcode() == 169) {
                LabelNode retlabel = null;
                Instantiation instantiation = instant;
                while (true) {
                    Instantiation p = instantiation;
                    if (p == null) {
                        break;
                    }
                    if (p.subroutine.get(i)) {
                        retlabel = p.returnLabel;
                    }
                    instantiation = p.previous;
                }
                if (retlabel == null) {
                    throw new RuntimeException("Instruction #" + i + " is a RET not owned by any subroutine");
                }
                newInstructions.add(new JumpInsnNode(167, retlabel));
            } else if (insn.getOpcode() == 168) {
                LabelNode lbl = ((JumpInsnNode) insn).label;
                BitSet sub = this.subroutineHeads.get(lbl);
                Instantiation newinst = new Instantiation(instant, sub);
                LabelNode startlbl = newinst.gotoLabel(lbl);
                newInstructions.add(new InsnNode(1));
                newInstructions.add(new JumpInsnNode(167, startlbl));
                newInstructions.add(newinst.returnLabel);
                worklist.add(newinst);
            } else {
                newInstructions.add(insn.clone(instant));
            }
        }
        for (TryCatchBlockNode trycatch : this.tryCatchBlocks) {
            LabelNode start = instant.rangeLabel(trycatch.start);
            LabelNode end = instant.rangeLabel(trycatch.end);
            if (start != end) {
                LabelNode handler = instant.gotoLabel(trycatch.handler);
                if (start == null || end == null || handler == null) {
                    throw new RuntimeException("Internal error!");
                }
                newTryCatchBlocks.add(new TryCatchBlockNode(start, end, handler, trycatch.type));
            }
        }
        for (LocalVariableNode lvnode : this.localVariables) {
            LabelNode start2 = instant.rangeLabel(lvnode.start);
            LabelNode end2 = instant.rangeLabel(lvnode.end);
            if (start2 != end2) {
                newLocalVariables.add(new LocalVariableNode(lvnode.name, lvnode.desc, lvnode.signature, start2, end2, lvnode.index));
            }
        }
    }

    private static void log(String str) {
        System.err.println(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.commons.JSRInlinerAdapter$Instantiation */
    /* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/commons/JSRInlinerAdapter$Instantiation.class */
    public class Instantiation extends AbstractMap<LabelNode, LabelNode> {
        final Instantiation previous;
        public final BitSet subroutine;
        public final Map<LabelNode, LabelNode> rangeTable = new HashMap();
        public final LabelNode returnLabel;

        Instantiation(Instantiation prev, BitSet sub) {
            this.previous = prev;
            this.subroutine = sub;
            Instantiation instantiation = prev;
            while (true) {
                Instantiation p = instantiation;
                if (p != null) {
                    if (p.subroutine != sub) {
                        instantiation = p.previous;
                    } else {
                        throw new RuntimeException("Recursive invocation of " + sub);
                    }
                } else {
                    if (prev != null) {
                        this.returnLabel = new LabelNode();
                    } else {
                        this.returnLabel = null;
                    }
                    LabelNode duplbl = null;
                    int c = JSRInlinerAdapter.this.instructions.size();
                    for (int i = 0; i < c; i++) {
                        AbstractInsnNode insn = JSRInlinerAdapter.this.instructions.get(i);
                        if (insn.getType() == 8) {
                            LabelNode ilbl = (LabelNode) insn;
                            duplbl = duplbl == null ? new LabelNode() : duplbl;
                            this.rangeTable.put(ilbl, duplbl);
                        } else if (findOwner(i) == this) {
                            duplbl = null;
                        }
                    }
                    return;
                }
            }
        }

        public Instantiation findOwner(int i) {
            if (!this.subroutine.get(i)) {
                return null;
            }
            if (!JSRInlinerAdapter.this.dualCitizens.get(i)) {
                return this;
            }
            Instantiation own = this;
            Instantiation instantiation = this.previous;
            while (true) {
                Instantiation p = instantiation;
                if (p != null) {
                    if (p.subroutine.get(i)) {
                        own = p;
                    }
                    instantiation = p.previous;
                } else {
                    return own;
                }
            }
        }

        public LabelNode gotoLabel(LabelNode l) {
            Instantiation owner = findOwner(JSRInlinerAdapter.this.instructions.indexOf(l));
            return owner.rangeTable.get(l);
        }

        public LabelNode rangeLabel(LabelNode l) {
            return this.rangeTable.get(l);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<LabelNode, LabelNode>> entrySet() {
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public LabelNode get(Object o) {
            return gotoLabel((LabelNode) o);
        }
    }
}
