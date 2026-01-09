import { DocType } from "../utils/documentProcessing.utils.ts"

export class Document {
    documentId: string
    userId: string
    documentType: DocType
    rawContent: string
    constructor(userId: string, documentType: DocType, rawContent: string) {
        this.documentId = crypto.randomUUID()
        this.userId = userId
        this.documentType = documentType
        this.rawContent = rawContent
    }
}