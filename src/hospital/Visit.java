package hospital;

public class Visit {

    private int visitId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    public Visit(int visitId, String visitDate,
                 String doctorName, String diagnosis,
                 String treatment) {

        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getVisitId() {

        return visitId;
    }

    public void displayVisit() {

        System.out.println("Visit ID   : " + visitId);
        System.out.println("Visit Date : " + visitDate);
        System.out.println("Doctor     : " + doctorName);
        System.out.println("Diagnosis  : " + diagnosis);
        System.out.println("Treatment  : " + treatment);

        System.out.println("------------------------");
    }
}