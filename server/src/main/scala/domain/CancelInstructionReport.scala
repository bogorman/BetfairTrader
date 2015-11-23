package domain

import domain.InstructionReportErrorCode.InstructionReportErrorCode
import domain.InstructionReportStatus.InstructionReportStatus
import org.joda.time.DateTime
import play.api.libs.json.{Json, Writes, Reads}

case class CancelInstructionReport(override val status: InstructionReportStatus,
                                   override val errorCode: Option[InstructionReportErrorCode],
                                   instruction: CancelInstruction,
                                   sizeCancelled: Option[Double],
                                   cancelledDate: Option[DateTime]) extends InstructionReport(status, errorCode)

object CancelInstructionReport {
  val dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
  implicit val dateTimeReads = Reads.jodaDateReads(dateFormat)
  implicit val dateTimeWrites = Writes.jodaDateWrites(dateFormat)
  implicit val formatCancelInstructionReport = Json.format[CancelInstructionReport]
}