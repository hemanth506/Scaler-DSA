import { Document } from "../models/Document.ts";
import { ProcessStep, StepPolicy } from "../utils/documentProcessing.utils.ts";
import type { IDocumentTypeService } from "./documentType.service.ts";
import type { IProcessingService } from "./processing.abstract.ts";

export type ProcessStepServiceMap = { [key: ProcessStep]: IProcessingService }

export type IEvent = {
    message: string,
    event: string,
    error: Error | null
}

export interface IDocumentService {
    execute(stepsArr: ProcessStep[], doc: Document): IEvent
}

const MAX_RETRIES = 3

export class DocumentService implements IDocumentService {
    private processStepServiceMap: ProcessStepServiceMap = {}
    constructor(ki: IProcessingService, ld: IProcessingService, ocr: IProcessingService, wm: IProcessingService, te: IProcessingService, vs: IProcessingService) {
        this.processStepServiceMap[ProcessStep.KEYWORD_INDEXING] = ki
        this.processStepServiceMap[ProcessStep.LANGUAGE_DETECTION] = ld
        this.processStepServiceMap[ProcessStep.OCR] = ocr
        this.processStepServiceMap[ProcessStep.PDF_WATERMARKING] = wm
        this.processStepServiceMap[ProcessStep.TEXT_EXTRACTION] = te
        this.processStepServiceMap[ProcessStep.VIRUS_SCAN] = vs
    }
    execute(stepsArr: ProcessStep[], doc: Document): IEvent {
        try {
            let hasExecutableStep = false
            for (let step of stepsArr) {
                const service = this.processStepServiceMap[step]
                if (!service.getApplicableDocType().includes(doc.documentType)) continue
                if (!service.isEnable) continue
                hasExecutableStep = true

                let attempts = 0

                while (true) {
                    try {
                        service.execute(doc)
                        break;
                    } catch (err) {
                        attempts++
                        switch (service.getStepPolicy()) {
                            case StepPolicy.RETRY:
                                if (attempts >= MAX_RETRIES) throw err
                                break

                            case StepPolicy.SKIP:
                                attempts = MAX_RETRIES
                                break

                            case StepPolicy.STOP:
                                throw err
                        }

                        if (attempts >= MAX_RETRIES) break
                    }
                }
            }
            if (hasExecutableStep) {
                return {
                    message: 'Document processed successfully',
                    event: 'DocumentProcessed',
                    error: null
                }
            } else {
                return {
                    message: 'Internal Error',
                    event: 'DocumentNotProcessed',
                    error: new Error("Doc type can't be processed")
                }
            }
        } catch (err: unknown) {
            return {
                message: 'Error when processing document',
                event: 'Failed',
                error: err instanceof Error ? err : new Error(String(err))
            }
        }
    }

} 