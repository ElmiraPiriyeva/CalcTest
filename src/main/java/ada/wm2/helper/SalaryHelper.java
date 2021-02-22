package ada.wm2.helper;

public class SalaryHelper {

    private static double GelirVergisi = 0.0;
    private static double OlkeYashayishMinMisli = 0.0;
    private static double DSMF = 0.0;
    private static double HemkarlarUzvlukHaqqi = 0.0;
    private static double IshsizlikSigortaHaqqi = 0.0;
    private static double IcbariTibbiSigortaHaqqi = 0.0;

    public static double getGV(double Gross, double OlkeYashayishMinMisli) {

        if (Gross > 2500.0) {
            GelirVergisi = 350.0 + ((Gross - 2500.0) * 0.25);
        } else {
            GelirVergisi = (Gross - OlkeYashayishMinMisli) * 0.14;
        }
        GelirVergisi = (double) Math.round(GelirVergisi * 100) / 100;

        return GelirVergisi;
    }

    public static double getDSMF(double Gross) {

        DSMF = Gross * 0.03;
        DSMF = (double) Math.round(DSMF * 100) / 100;

        return DSMF;
    }

    public static double getHTUN(double Gross, double LaborUnionFee) {

        HemkarlarUzvlukHaqqi = (double) Math.round((Gross * LaborUnionFee / 100.0) * 100.0) / 100.0;

        return HemkarlarUzvlukHaqqi;
    }

    public static double getISH(double Gross) {

        IshsizlikSigortaHaqqi = (double) Math.round((Gross * 0.5 / 10.0) * 10.0) / 100.0;

        return IshsizlikSigortaHaqqi;
    }

    public static double NetToGross2018(double Net){
        double Gross = 0.0;

        if(Net < 2086.72){
            Gross = (Net - 24.22) / 0.825;
            Gross = (double) Math.round(Gross * 100) / 100;
        }
        else if(Net > 2086.72){
            Gross = (Net - 275) / 0.715;
            Gross = (double) Math.round(Gross * 100) / 100;
        }

        return Gross;
    }
    public static double NetToGross2019(double Net){
        double Gross = 0.0;

        if(Net < 2086.72){
            Gross = (Net - 24.22) / 0.825;
            Gross = (double) Math.round(Gross * 100) / 100;
        }
        else if(Net > 2086.72){
            Gross = (Net - 275) / 0.715;
            Gross = (double) Math.round(Gross * 100) / 100;
        }

        return Gross;
    }
    public static double GrossToNet2017(int Guzesht, double AyliqEmekHaqqi, double LaborUnionFee) {
        double Net = 0.0;
        double VergiMeblegi;
        VergiMeblegi = AyliqEmekHaqqi - Guzesht;

        OlkeYashayishMinMisli = 155.0;
        GelirVergisi = getGV(VergiMeblegi, OlkeYashayishMinMisli);
        DSMF = getDSMF(AyliqEmekHaqqi);
        HemkarlarUzvlukHaqqi = getHTUN(AyliqEmekHaqqi, LaborUnionFee);
        Net = AyliqEmekHaqqi - GelirVergisi - DSMF - HemkarlarUzvlukHaqqi;
        Net = (double) Math.round(Net * 100) / 100;

        return Net;
    }

    public static double GrossToNet2018(int Guzesht, double AyliqEmekHaqqi, double LaborUnionFee) {
        double Net = 0.0;
        double VergiMeblegi;
        VergiMeblegi = AyliqEmekHaqqi - Guzesht;


        OlkeYashayishMinMisli = 173.0;
        GelirVergisi = getGV(VergiMeblegi, OlkeYashayishMinMisli);
        DSMF = getDSMF(AyliqEmekHaqqi);
        IshsizlikSigortaHaqqi = getISH(AyliqEmekHaqqi);
        HemkarlarUzvlukHaqqi = getHTUN(AyliqEmekHaqqi, LaborUnionFee);
        Net = AyliqEmekHaqqi - GelirVergisi - DSMF - IshsizlikSigortaHaqqi - HemkarlarUzvlukHaqqi;
        Net = (double) Math.round(Net * 100) / 100;

        return Net;
    }

    public static double GrossToNet2019(int Guzesht, boolean bPublicSector, double AyliqEmekHaqqi, double LaborUnionFee) {
        double Net = 0.0;
        double VergiMeblegi;
        VergiMeblegi = AyliqEmekHaqqi - Guzesht;

        OlkeYashayishMinMisli = 200.0;

        if (bPublicSector) {
            if (AyliqEmekHaqqi < OlkeYashayishMinMisli) {
                GelirVergisi = 0.0;
                DSMF = getDSMF(AyliqEmekHaqqi);
            } else if (AyliqEmekHaqqi > OlkeYashayishMinMisli && VergiMeblegi <= 8000.0) {
                GelirVergisi = 0.0;
                DSMF = (AyliqEmekHaqqi - OlkeYashayishMinMisli) * 0.1 + 6.0;
                DSMF = (double) Math.round(DSMF * 100.0) / 100.0;

            } else if (AyliqEmekHaqqi > OlkeYashayishMinMisli && VergiMeblegi > 8000.0) {
                GelirVergisi = (double) Math.round((VergiMeblegi - 8000.0) * 0.14 * 100.0) / 100.0;
                DSMF = (AyliqEmekHaqqi - OlkeYashayishMinMisli) * 0.1 + 6.0;
                DSMF = (double) Math.round(DSMF * 100.0) / 100.0;
            }

            IshsizlikSigortaHaqqi = getISH(AyliqEmekHaqqi);
            HemkarlarUzvlukHaqqi = getHTUN(AyliqEmekHaqqi, LaborUnionFee);

            Net = AyliqEmekHaqqi - GelirVergisi - DSMF - IshsizlikSigortaHaqqi - HemkarlarUzvlukHaqqi;
            Net = (double) Math.round(Net * 100) / 100;

        } else {
            GelirVergisi = getGV(VergiMeblegi, OlkeYashayishMinMisli);
            DSMF = getDSMF(AyliqEmekHaqqi);
            IshsizlikSigortaHaqqi = getISH(AyliqEmekHaqqi);
            HemkarlarUzvlukHaqqi = getHTUN(AyliqEmekHaqqi, LaborUnionFee);

            Net = AyliqEmekHaqqi - GelirVergisi - DSMF - IshsizlikSigortaHaqqi - HemkarlarUzvlukHaqqi;
            Net = (double) Math.round(Net * 100) / 100;
        }

        return Net;
    }
    public static double GrossToNet2020(int Guzesht, boolean bPublicSector, double AyliqEmekHaqqi, double LaborUnionFee) {
        double Net = 0.0;
        double VergiMeblegi;
        VergiMeblegi = AyliqEmekHaqqi - Guzesht;

        OlkeYashayishMinMisli = 200.0;

        if (bPublicSector) {
            if (AyliqEmekHaqqi < OlkeYashayishMinMisli) {
                GelirVergisi = 0.0;
                DSMF = getDSMF(AyliqEmekHaqqi);
            } else if (AyliqEmekHaqqi > OlkeYashayishMinMisli && VergiMeblegi <= 8000.0) {
                GelirVergisi = 0.0;
                DSMF = (AyliqEmekHaqqi - OlkeYashayishMinMisli) * 0.1 + 6.0;
                DSMF = (double) Math.round(DSMF * 100.0) / 100.0;
                IcbariTibbiSigortaHaqqi= (AyliqEmekHaqqi * 0.02) / 2;
                IcbariTibbiSigortaHaqqi = (double) Math.round(IcbariTibbiSigortaHaqqi * 100.0) / 100.0;


            } else if (AyliqEmekHaqqi > OlkeYashayishMinMisli && VergiMeblegi > 8000.0) {
                GelirVergisi = (double) Math.round((VergiMeblegi - 8000.0) * 0.14 * 100.0) / 100.0;
                DSMF = (AyliqEmekHaqqi - OlkeYashayishMinMisli) * 0.1 + 6.0;
                DSMF = (double) Math.round(DSMF * 100.0) / 100.0;
                IcbariTibbiSigortaHaqqi= (AyliqEmekHaqqi - 8000.0) * 0.005 + 160.0 / 2;
                IcbariTibbiSigortaHaqqi = (double) Math.round(IcbariTibbiSigortaHaqqi * 100.0) / 100.0;
            }

            IshsizlikSigortaHaqqi = getISH(AyliqEmekHaqqi);
            HemkarlarUzvlukHaqqi = getHTUN(AyliqEmekHaqqi, LaborUnionFee);

            Net = AyliqEmekHaqqi - GelirVergisi - DSMF - IshsizlikSigortaHaqqi - HemkarlarUzvlukHaqqi - IcbariTibbiSigortaHaqqi;
            Net = (double) Math.round(Net * 100) / 100;

        } else {
            GelirVergisi = getGV(VergiMeblegi, OlkeYashayishMinMisli);
            DSMF = getDSMF(AyliqEmekHaqqi);
            IshsizlikSigortaHaqqi = getISH(AyliqEmekHaqqi);
            HemkarlarUzvlukHaqqi = getHTUN(AyliqEmekHaqqi, LaborUnionFee);
            if(VergiMeblegi > 8000.0){
                IcbariTibbiSigortaHaqqi= (AyliqEmekHaqqi - 8000.0) * 0.005;
                IcbariTibbiSigortaHaqqi = (double) Math.round(IcbariTibbiSigortaHaqqi * 100.0) / 100.0;
            }
            else if(VergiMeblegi <= 8000.0){
                IcbariTibbiSigortaHaqqi= (AyliqEmekHaqqi * 0.02);
                IcbariTibbiSigortaHaqqi = (double) Math.round(IcbariTibbiSigortaHaqqi * 100.0) / 100.0;
            }

            Net = AyliqEmekHaqqi - GelirVergisi - DSMF - IshsizlikSigortaHaqqi - HemkarlarUzvlukHaqqi - IcbariTibbiSigortaHaqqi;
            Net = (double) Math.round(Net * 100) / 100;
        }

        return Net;
    }


}
