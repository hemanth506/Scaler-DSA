import { Document } from "../models/Document.ts";
import type { IOrchestrator } from "../orchestrators/processOrchestrator.ts";

export class UploadService {
    document?: Document
    private orchestrator: IOrchestrator
    constructor(orchestrator: IOrchestrator) {
        this.orchestrator = orchestrator
    }
    upload(document: Document) {
        this.document = document
    }
    startProcess() {
        if(this.document) {
            this.orchestrator.orchestrate(this.document)
        }
    }
}