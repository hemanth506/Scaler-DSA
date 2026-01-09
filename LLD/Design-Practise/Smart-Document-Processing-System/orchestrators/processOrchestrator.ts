import { Document } from "../models/Document.ts";
import type { IDocumentService, IEvent } from "../services/document.service.ts";
import type { IDocumentTypeService } from "../services/documentType.service.ts";
import { ProcessStep } from "../utils/documentProcessing.utils.ts";

export interface IOrchestrator {
    orchestrate(document: Document): void
}

export class ProcessOrchestrator implements IOrchestrator {
    private dtService: IDocumentTypeService
    private dService: IDocumentService
    constructor(dtService: IDocumentTypeService, dService: IDocumentService) {
        this.dtService = dtService
        this.dService = dService
    }
    orchestrate(doc: Document): void {
        const stepsArr: ProcessStep[] = this.dtService.getStepsForDocType(doc.documentType)
        
        const event: IEvent = this.dService.execute(stepsArr, doc)
        console.log(event);
        // Send notification
    }
}