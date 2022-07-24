public class Contents {
    //final não permite alterar o valor depois de instanciar um novo objeto.
    private final String title;
    private final String urlImage;

    public Contents(String title, String urlImage) {
        this.title = title;
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }
    public String getUrlImage() {
        return urlImage;
    }
    //desafio adaptar para Record
    //estudar exceções
    //estudar lambda, copiar lista para outra
    //usar ENUM;

}
