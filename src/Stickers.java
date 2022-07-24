import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Stickers {

    public void create(InputStream inputStream, String nomeArquivo) throws Exception{
        // Dica: control + . em cima do objeto permite escolher para criar uma variável
        // F2 em palavra selecionada: troca por novo texto em todo lugar que for encontrada.
        // alt shif O = faz importes necessários.
        // thumbnail https://m.media-amazon.com/images/M/MV5BNDJhYTk2MTctZmVmOS00OTViLTgxNjQtMzQxOTRiMDdmNGRjXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,1,128,176_AL_.jpg
        // retirada: ._V1_UX128_CR0,1,128,176_AL_
        // maior https://m.media-amazon.com/images/M/MV5BNDJhYTk2MTctZmVmOS00OTViLTgxNjQtMzQxOTRiMDdmNGRjXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,1,128,176_AL_.jpg
        //leitura da imagem
        // os dois tipos de inputStream (classe mais abstrata possível) é um exemplo de polimorfismo.
        //InputStream inputStream = new FileInputStream(new File("image/filme.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BNDJhYTk2MTctZmVmOS00OTViLTgxNjQtMzQxOTRiMDdmNGRjXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,1,128,176_AL_.jpg").openStream();
        BufferedImage originalImage = ImageIO.read(inputStream);

        //criar nova imagem com transparencia com tamanho novo
        int width = originalImage.getWidth();  
        int height = originalImage.getHeight();      
        int newHeight = height + 20;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        //configurar a fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 22);
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);


        //escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 10, newHeight - 10);

        //escrever a nova imagem um novo arquivo
        ImageIO.write(newImage, "png", new File(nomeArquivo));
    }


    // public static void main(String[] args) throws Exception {
    //     Stickers stickers = new Stickers();
    //     stickers.create();
    // }
    
}
