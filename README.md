# FormFX

FormFX helps you make form very easily in JavaFX.

### Version

1.0.0


### Introduction

In the past, I used a lot of Labels, Controls, HBox, GridPane, etc. to create a form in JavaFX. I thought it was too hard to create a form. I wanted to create a form more quickly and more easily. So I spent some time to make this tool. Hope you like it.

### Some Definitions

1. **Field** - The smallest part of a form. Usally it contains a Label and a Control.
2. **FieldGroup** - A list of fields to build the form.
3. **OptionList** - Common Items of some controls like RadioButton, CheckBox, ComboBox etc.
4. **CasualForm** - A form that organize the fields casually.
5. **GridForm** - A form that use grid to organize the fields, which looks regular.

### Quick Start

- #### Use FieldGroup To Create A GridForm

``` #id ``` is the id of the Field. The class ``` Input ``` help you instantiate Fields of different type quickly. To put some Fileds into a FieldGroup, you can use the method ``` join() ``` . With a FieldGroup, you can generate a GridForm or a CasualForm.

```
public class GridFormDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    
        // Create a FieldGroup
        FieldGroup fieldGroup = new FieldGroup() {{
            join("#username", "Username:", Input.textField("Please input your username"));
            join("#pwd", "Password:", Input.passwordField("Please input your password"));
            join("#gender", "Gender:", Input.radioButtonBox(
                    new OptionList() {{
                        add("boy", true);
                        add("girl");
                    }}));
            join("#bir", "Birthday:", Input.datePicker());
            join("#hobby", "Hobby:", Input.checkBox(
                    new OptionList() {{
                        add("basketball", true);
                        add("soccer");
                        add("program");
                    }}));
            join("#job", "Job:", Input.comboBox(
                    new OptionList() {{
                        add("programmer");
                        add("student", true);
                        add("teacher");
                    }}));
            join("#about", "About:", Input.textArea(250, -1, "Write something about you"));
        }};
        
        // Create a GridForm
        GridForm gridForm = new GridForm(fieldGroup);
        gridForm.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridForm);
        stage.setTitle("GridForm Demo");
        stage.setScene(scene);
        stage.show();

    }
    
}
```
Run this Demo and you can see the form :

![image](https://github.com/YoriChan/FormFX/blob/master/img/GridFormDemo_V.png)

Then, you can change the Field column number by using the method ``` setColumnNum() ```

```
gridForm.setColumnNum(2);
```
![image](https://github.com/YoriChan/FormFX/blob/master/img/GridFormDemo_2Col.png)

And change the Orientation of the Fields by using the method ``` setFieldOrientation() ```

```
        gridForm.setFieldOrientation(Orientation.HORIZONTAL);
```
![image](https://github.com/YoriChan/FormFX/blob/master/img/GridFormDemo_H.png)


- #### Create A CasualForm
Similarly, you can use the FieldGroup to create a CasualField. You can use the method ``` separate() ``` to separate the group into some rows.

```
public class CasualFormDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Create a FieldGroup
        FieldGroup fieldGroup = new FieldGroup() {{
            join("#username", "Username:", Input.textField("Please input your username"));
            join("#pwd", "Password:", Input.passwordField("Please input your password"));
            join("#gender", "Gender:", Input.radioButtonBox(
                    new OptionList() {{
                        add("boy", true);
                        add("girl");
                    }}));
            separate();
            join("#bir", "Birthday:", Input.datePicker("Please select your birthday"));
            join("#hobby", "Hobby:", Input.checkBox(
                    new OptionList() {{
                        add("basketball", true);
                        add("soccer");
                        add("program");
                    }}));
            join("#job", "Job:", Input.comboBox(
                    new OptionList() {{
                        add("programmer");
                        add("student", true);
                        add("teacher");
                    }}));
            separate();
            join("#about", "About:", Input.textArea("Write something about you"));
        }};

        // Create a CasualForm
        CasualForm gridForm = new CasualForm(fieldGroup);
        gridForm.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridForm);
        stage.setTitle("CasualForm Demo");
        stage.setScene(scene);
        stage.show();

    }

}
```
![image](https://github.com/YoriChan/FormFX/blob/master/img/CasualFormDemo.png)

- #### Fill Form Data In Your Object

At first, you should use the annotation ``` @FieldId ``` to map the form fields to the class's properties.

```
public class User {

    @FieldId("#username")
    private String username;
    
    @FieldId("#pwd")
    private String pwd;

    @FieldId("#gender")
    private String gender;

    @FieldId("#bir")
    private Date birthday;

    @FieldId("#hobby")
    private List<String> hobby;

    @FieldId("#job")
    private String job;

    @FieldId("#about")
    private String about;

    @FieldId("#file")
    private File file;

    // getters and setters...

}
```
Use the method ``` fill() ``` to fill the data of form in your object.

```
User user = new User();
gridForm.fill(user);

```