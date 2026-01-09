export const DocType = {
    PDF: "PDF",
    DOCX: "DOCX",
    IMAGE: "IMAGE"
}

export type DocType = (typeof DocType)[keyof typeof DocType]

export const ProcessStep = {
    KEYWORD_INDEXING: 'KEYWORD_INDEXING',
    LANGUAGE_DETECTION: 'LANGUAGE_DETECTION',
    OCR: 'OCR',
    PDF_WATERMARKING: 'PDF_WATERMARKING',
    TEXT_EXTRACTION: 'TEXT_EXTRACTION',
    VIRUS_SCAN: 'VIRUS_SCAN'
}

export type ProcessStep = (typeof ProcessStep)[keyof typeof ProcessStep]


export const StepPolicy = {
    RETRY: 'RETRY',
    SKIP: 'SKIP',
    STOP: 'STOP'
}

export type StepPolicy = (typeof StepPolicy)[keyof typeof StepPolicy]

