package glenn;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;
    private TextField nameField;
    private Label nameLabel;

    public HomePage(final PageParameters parameters) {
        super(parameters);

        add(new HelloForm("hello"));
    }
    class HelloForm extends Form {

        public HelloForm(String id) {
            super(id);
           nameField = new TextField("name", Model.of(""));
           nameLabel = new Label("nameLabel",Model.of(""));
           add(nameField);
           add(nameLabel);
           
        }
        public final void onSubmit() {
            String name = (String) nameField.getDefaultModelObject();
            String greeting = "Hello " + name + "!";
            nameLabel.setDefaultModelObject(greeting);
        }
        
    }

}
