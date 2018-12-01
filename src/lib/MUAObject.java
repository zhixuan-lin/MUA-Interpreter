package lib;

abstract public class MUAObject {
    public enum Type {
        NUMBER,
        WORD,
        LIST,
        BOOL,
        ANY;

        @Override
        public String toString() {
            switch (this) {
                case NUMBER: return "number";
                case WORD: return "word";
                case LIST: return "list";
                case BOOL: return "bool";
            }
            return "UNKNOWN";
        }
    }

    private Type type;


    protected MUAObject(Type type) {
        this.type = type;
    }


    public Type getType() {
        return type;
    }

    @Override
    abstract public String toString();

    abstract public Object getValue();

}
