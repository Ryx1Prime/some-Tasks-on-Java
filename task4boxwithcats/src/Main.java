public class Main{
    public static void main(String[] args) {
        BoxOFcats mybox = BoxOFcats.createCat(3);
        System.out.println("создаём");
        mybox.printAllCats();

        mybox.addCat(new CATT("муся"));
        mybox.removeCats("Барсик 2");

        System.out.println("изменения");
        mybox.printAllCats();

    }
}