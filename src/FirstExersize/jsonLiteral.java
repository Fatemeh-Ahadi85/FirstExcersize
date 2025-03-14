package FirstExersize;

abstract class jsonLiteral {
    public abstract Object getValue();
    protected String input;

    public jsonLiteral(String input){
        this.input = input;
    }
    public Object Value(){
        return getValue();
    }
}
