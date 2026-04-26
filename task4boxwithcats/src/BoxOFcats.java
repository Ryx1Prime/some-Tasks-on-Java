import java.util.ArrayList;

public class BoxOFcats {
    private ArrayList<CATT> cats;

    public BoxOFcats(){
        this.cats = new ArrayList<>();
    }

    public void addCat(CATT cat){
        if (cat != null){
            cats.add(cat);
        }
    }

    public void removeCats(String name){
        for (int i = 0; i < cats.size(); i++){
            CATT nowCat = cats.get(i);
            if (nowCat.getName().equalsIgnoreCase(name)){
                cats.remove(i);
                return;
            }
        }
        System.out.println("такой кошки нет");
    }
    public void printAllCats(){
        for(CATT c : cats){
            System.out.println(c.toString());
        }
    }

    public static BoxOFcats createCat(int num){
        BoxOFcats box = new BoxOFcats();
        for (int i =1; i <= num; i++){
            box.addCat(new CATT("Барсик " + i));
        }
        return box;
    }

}
