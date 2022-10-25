package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.IFrame;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.LabelInfo;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.MethodProbesVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.MethodInstrumenter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/MethodInstrumenter.class */
class MethodInstrumenter extends MethodProbesVisitor {
    private final IProbeInserter probeInserter;

    public MethodInstrumenter(MethodVisitor mv, IProbeInserter probeInserter) {
        super(mv);
        this.probeInserter = probeInserter;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.MethodProbesVisitor
    public void visitProbe(int probeId) {
        this.probeInserter.insertProbe(probeId);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.MethodProbesVisitor
    public void visitInsnWithProbe(int opcode, int probeId) {
        this.probeInserter.insertProbe(probeId);
        this.f10701mv.visitInsn(opcode);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.MethodProbesVisitor
    public void visitJumpInsnWithProbe(int opcode, Label label, int probeId, IFrame frame) {
        if (opcode == 167) {
            this.probeInserter.insertProbe(probeId);
            this.f10701mv.visitJumpInsn(167, label);
            return;
        }
        Label intermediate = new Label();
        this.f10701mv.visitJumpInsn(getInverted(opcode), intermediate);
        this.probeInserter.insertProbe(probeId);
        this.f10701mv.visitJumpInsn(167, label);
        this.f10701mv.visitLabel(intermediate);
        frame.accept(this.f10701mv);
    }

    private int getInverted(int opcode) {
        switch (opcode) {
            case 153:
                return 154;
            case 154:
                return 153;
            case 155:
                return 156;
            case 156:
                return 155;
            case 157:
                return 158;
            case 158:
                return 157;
            case 159:
                return 160;
            case 160:
                return 159;
            case 161:
                return 162;
            case 162:
                return 161;
            case 163:
                return 164;
            case 164:
                return 163;
            case 165:
                return 166;
            case 166:
                return 165;
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
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
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            default:
                throw new IllegalArgumentException();
            case 198:
                return 199;
            case 199:
                return 198;
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.MethodProbesVisitor
    public void visitTableSwitchInsnWithProbes(int min, int max, Label dflt, Label[] labels, IFrame frame) {
        LabelInfo.resetDone(dflt);
        LabelInfo.resetDone(labels);
        Label newDflt = createIntermediate(dflt);
        Label[] newLabels = createIntermediates(labels);
        this.f10701mv.visitTableSwitchInsn(min, max, newDflt, newLabels);
        insertIntermediateProbes(dflt, labels, frame);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.MethodProbesVisitor
    public void visitLookupSwitchInsnWithProbes(Label dflt, int[] keys, Label[] labels, IFrame frame) {
        LabelInfo.resetDone(dflt);
        LabelInfo.resetDone(labels);
        Label newDflt = createIntermediate(dflt);
        Label[] newLabels = createIntermediates(labels);
        this.f10701mv.visitLookupSwitchInsn(newDflt, keys, newLabels);
        insertIntermediateProbes(dflt, labels, frame);
    }

    private Label[] createIntermediates(Label[] labels) {
        Label[] intermediates = new Label[labels.length];
        for (int i = 0; i < labels.length; i++) {
            intermediates[i] = createIntermediate(labels[i]);
        }
        return intermediates;
    }

    private Label createIntermediate(Label label) {
        Label intermediate;
        if (LabelInfo.getProbeId(label) == -1) {
            intermediate = label;
        } else if (LabelInfo.isDone(label)) {
            intermediate = LabelInfo.getIntermediateLabel(label);
        } else {
            intermediate = new Label();
            LabelInfo.setIntermediateLabel(label, intermediate);
            LabelInfo.setDone(label);
        }
        return intermediate;
    }

    private void insertIntermediateProbe(Label label, IFrame frame) {
        int probeId = LabelInfo.getProbeId(label);
        if (probeId != -1 && !LabelInfo.isDone(label)) {
            this.f10701mv.visitLabel(LabelInfo.getIntermediateLabel(label));
            frame.accept(this.f10701mv);
            this.probeInserter.insertProbe(probeId);
            this.f10701mv.visitJumpInsn(167, label);
            LabelInfo.setDone(label);
        }
    }

    private void insertIntermediateProbes(Label dflt, Label[] labels, IFrame frame) {
        LabelInfo.resetDone(dflt);
        LabelInfo.resetDone(labels);
        insertIntermediateProbe(dflt, frame);
        for (Label l : labels) {
            insertIntermediateProbe(l, frame);
        }
    }
}
