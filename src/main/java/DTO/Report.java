package DTO;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Report implements Serializable {
	private int reportId;
    private String reportReason;

    // Khai báo các phương thức khởi tạo
    public Report() {
    }

    public Report(int reportId, String reportReason) {
        this.reportId = reportId;
        this.reportReason = reportReason;
    }

    // Khai báo các phương thức getter và setter cho các thuộc tính
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }
}
