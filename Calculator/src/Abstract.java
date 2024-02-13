public abstract class Abstract{
  protected String name;
  protected int width;
  protected int height;

  //C Abstract constructor
  public Abstract(String name,int width,int height){
    this.name=name;
    this.width=width;
    this.height=height;
  }

  //Abstract methods
  public abstract void render();
  public abstract void onClick();

 //Concrete setter method that enables the change of component names
 public void setName(String name) {
    this.name = name;
 }

}