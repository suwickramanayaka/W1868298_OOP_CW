import java.io.IOException;

public interface SkinConsultationManager {

    public void addDoctor(WestminsterSkinConsultationManager westminsterSkinConsultationManager);

    public void deleteDoctor(WestminsterSkinConsultationManager westminsterSkinConsultationManager);

    public void printDoctor(WestminsterSkinConsultationManager westminsterSkinConsultationManager);

    public void saveInFile(WestminsterSkinConsultationManager westminsterSkinConsultationManager) throws IOException;
}
