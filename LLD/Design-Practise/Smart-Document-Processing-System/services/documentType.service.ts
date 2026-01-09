import { DocType, ProcessStep } from "../utils/documentProcessing.utils.ts";

type MandatoryDocTypeSteps = { [key: DocType]: ProcessStep[] }

export interface IDocumentTypeService {
    addStepsForDocType(position: number, docType: DocType, step: ProcessStep): void
    getStepsForDocType(docType: DocType): ProcessStep[]
    updateStepOrderForDocType(position: number, docType: DocType, step: ProcessStep): void
}

export class DocumentTypeService implements IDocumentTypeService{
    private mandatoryDocTypeSteps: MandatoryDocTypeSteps = {
        [DocType.DOCX]: [],
        [DocType.IMAGE]: [ProcessStep.VIRUS_SCAN],
        [DocType.PDF]: [ProcessStep.VIRUS_SCAN],
    }
    public addStepsForDocType(position: number, docType: DocType, step: ProcessStep) {
        if (!this.mandatoryDocTypeSteps[docType].includes(step)) {
            this.mandatoryDocTypeSteps[docType].splice(position, 0, step)
        }
    }
    public getStepsForDocType(docType: DocType) {
        return this.mandatoryDocTypeSteps[docType]
    }
    public updateStepOrderForDocType(position: number, docType: DocType, step: ProcessStep) {
        if (this.mandatoryDocTypeSteps[docType].includes(step)) {
            this.mandatoryDocTypeSteps[docType].splice(position, 0, step)
        }
    }
}