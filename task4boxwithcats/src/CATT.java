public class CATT {
    private String name;

    public CATT(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "Кот {имя='" + name + "'}";
    }
}
