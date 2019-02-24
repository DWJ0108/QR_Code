import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Hashtable;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

public class Generate {
    public static void main(String[] args) throws IOException {
        String text="www.baidu.com";
        int width=300;
        int height=300;
        String format="png";
        //二维码参数
        Hashtable hints=new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   //编码设置
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); //识别级别
        hints.put(EncodeHintType.MARGIN, 2);    //边距
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
            Path file=new File("./qr_code.png").toPath();//在F盘生成二维码图片
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
