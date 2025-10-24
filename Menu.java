public class Menu {
    private String header = "Default header";
    private String prompt = "Default prompt: ";
    private String separator = "----------------";

    protected Menu(String h, String p) {
        this.header = h;
        this.prompt = p;
    }

    public String getHeader() {
        return this.header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public String getPrompt() {
        return this.prompt;
    }
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    public String getSeparator() {
        return this.separator;
    }
    public void setSeparator(String separator) {
        this.separator = separator;
    }
}




