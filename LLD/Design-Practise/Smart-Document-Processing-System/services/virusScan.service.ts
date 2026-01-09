import { Document } from "../models/Document.ts";
import { DocType, StepPolicy } from "../utils/documentProcessing.utils.ts";
import { ProcessingService } from "./processing.abstract.ts";

export class VirusScanService extends ProcessingService {
    constructor(applicableDocType: DocType[], status: boolean, sp: StepPolicy) {
        super(applicableDocType, status, sp)
    }
    execute(doc: Document): void {
        // console.log('VirusScanService is executing', doc);
        throw new Error("Error in Virus Scanning")
    }
}