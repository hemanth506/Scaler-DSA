import { Document } from "../models/Document.ts"
import { DocType, StepPolicy } from "../utils/documentProcessing.utils.ts"

export interface IProcessingService {
    isEnable: boolean
    applicableDocType: DocType[]
    addApplicableDocType(docType: DocType): void
    getApplicableDocType(): DocType[]
    setIsEnable(status: boolean): void
    getIsEnable(): boolean
    stepPolicy: StepPolicy
    getStepPolicy(): StepPolicy
    setStepPolicy(sp: StepPolicy): void
    execute(doc: Document): void
}

export abstract class ProcessingService implements IProcessingService {
    applicableDocType: DocType[]
    isEnable: boolean
    stepPolicy: StepPolicy
    constructor(applicableDocType: DocType[], status: boolean, stepPolicy: StepPolicy) {
        this.applicableDocType = [...applicableDocType]
        this.isEnable = status
        this.stepPolicy = stepPolicy
    }
    getStepPolicy(): StepPolicy { return this.stepPolicy }
    setStepPolicy(sp: StepPolicy): void { this.stepPolicy = sp }
    addApplicableDocType(docType: DocType) {
        if (!this.applicableDocType.includes(docType)) {
            this.applicableDocType.push(docType)
        }
    }
    getApplicableDocType() { return this.applicableDocType }
    setIsEnable(status: boolean) { this.isEnable = status }
    getIsEnable() { return this.isEnable }
    abstract execute(doc: Document): void
}