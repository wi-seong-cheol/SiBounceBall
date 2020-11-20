package gamecomponents;

public class SpawnElectricity extends Spawn
{ 
  public SpawnElectricity(int x, int y)
  {
    this.x = x;
    this.y = y;
    this.type = 0;
    this.length = 15.0;
  }
  
  @Override
  public double getX1() //(X1, Y1)-> 좌상 점좌표
  {
    return this.x - length;
  }
  @Override
  public double getY1()
  {
    return this.y - length;
  }
  @Override
  public double getX2() //(X2, Y2)-> 우하 점좌표
  {
    return this.x + length;
  }
  @Override
  public double getY2()
  {
    return this.y + length;
  }
}
