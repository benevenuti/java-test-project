import java.time.LocalDate;
import java.util.List;

public class EstimateParam {

    private final ClientTypeEnum clientType;
    private final List<LocalDate> datas;

    public EstimateParam(ClientTypeEnum clientType, List<LocalDate> datas) {

        this.clientType = clientType;
        this.datas = datas;
    }

    public ClientTypeEnum getClientType() {
        return clientType;
    }

    public List<LocalDate> getDatas() {
        return datas;
    }
}
