import { Document } from "./models/Document.ts";
import { ProcessOrchestrator } from "./orchestrators/processOrchestrator.ts";
import { DocumentService } from "./services/document.service.ts";
import { DocumentTypeService } from "./services/documentType.service.ts";
import { KeywordIndexingService } from "./services/keywordIndexing.service.ts";
import { LanguageDetectionService } from "./services/languageDetection.service.ts";
import { OCRService } from "./services/ocr.service.ts";
import { PdfWaterMarkingService } from "./services/pdfWatermarking.service.ts";
import { TextExtractionService } from "./services/textExtraction.service.ts";
import { UploadService } from "./services/upload.service.ts";
import { VirusScanService } from "./services/virusScan.service.ts";
import { DocType, StepPolicy } from "./utils/documentProcessing.utils.ts";

// creation phase
const rawContent = 'This is just a raw content'
const document = new Document(crypto.randomUUID(), DocType.DOCX, rawContent)

// Execution phase
const kiApplicableDocType: DocType[] = [DocType.DOCX]
const ki = new KeywordIndexingService(kiApplicableDocType, true, StepPolicy.SKIP)

const ldApplicableDocType: DocType[] = [DocType.DOCX]
const ld = new LanguageDetectionService(ldApplicableDocType, true, StepPolicy.SKIP)

const ocrApplicableDocType: DocType[] = [DocType.IMAGE]
const ocr = new OCRService(ocrApplicableDocType, true, StepPolicy.RETRY)

const wmApplicableDocType: DocType[] = [DocType.PDF]
const wm = new PdfWaterMarkingService(wmApplicableDocType, true, StepPolicy.STOP)

const teApplicableDocType: DocType[] = [DocType.DOCX]
const te = new TextExtractionService(teApplicableDocType, true, StepPolicy.STOP)

const vsApplicableDocType: DocType[] = [DocType.IMAGE, DocType.PDF]
const vs = new VirusScanService(vsApplicableDocType, true, StepPolicy.RETRY)



const dtService = new DocumentTypeService()
const dService = new DocumentService(ki, ld, ocr, wm, te, vs)

const orchestrator = new ProcessOrchestrator(dtService, dService)
const uploadService = new UploadService(orchestrator)

uploadService.upload(document)
uploadService.startProcess()


vs.setStepPolicy(StepPolicy.STOP)
console.log('After changing the policy in run time.');
uploadService.startProcess()
