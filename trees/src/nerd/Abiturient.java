package nerd;

public class Abiturient implements Comparable{
    private String name;
    private String gender;
    private String address;
    private String facultet;
    private int num_school;
    private int[] exam_bal;
    private boolean isCommercial;
    private int cost_learn;
    private int number;
    public Abiturient(String name, String gender, String address, String facultet, int num_school, int ex1, int ex2, int ex3, boolean isCommercial, int cost_learn){
        this.name=name;
        this.gender=gender;
        this.address=address;
        this.facultet=facultet;
        this.num_school=num_school;
        this.exam_bal=new int[3];
        this.exam_bal[0]=ex1;
        this.exam_bal[1]=ex2;
        this.exam_bal[2]=ex3;
        this.isCommercial=isCommercial;
        this.cost_learn=cost_learn;
        this.number=nextNumber();
    }
    public int nextNumber(){
        return this.number=(int)(+Math.random()*100);
    }
    public int getNumber(){
        return number;
    }

    public Abiturient(int number){
        this.number=number;
    }

    public Abiturient(String name, String gender, String address, String facultet, int num_school, int ex1, int ex2, int ex3){
        this(name,gender,address, facultet,num_school, ex1, ex2, ex3, false,0);
    }

    @Override
    public String toString(){
        String s= isCommercial ? "учится на коммерческой основе, стоимость обучения= "+cost_learn : "учится на бюджетной основе";
        return number+".Абитуриент "+name+", факультет: "+facultet+", "+s;
    }

    public int getNumSchool(){
        return num_school;
    }

    public float getBal(){
        return ((float)(exam_bal[0]+exam_bal[1]+exam_bal[3]))/3;
    }

    @Override
    public int CompareTo(Object o) {
        Abiturient newA = (Abiturient) o;
        if(this.number>newA.number) return 1;
        else{
            if(this.number<newA.number) return -1;
            else{
                return 0;
            }
        }
    }
}
