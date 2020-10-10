import java.util.ArrayList;

class NumberingManeger{

  Integer balls= new Integer(10);//モンスターを捕まえられるボールの数
  Integer fruits=new Integer(0);//ぶつけるとモンスターが捕まえやすくなるフルーツ
  Double distance=new Double(0.0);//歩いた距離
  ArrayList<Double> eggDistance = new ArrayList<Double>();
	ArrayList<Boolean> egg = new ArrayList<Boolean>();


  // public void add_balls(int n){
  //   balls = balls + n;
  // }
  public void ball_and_fruit_and_egg_get(){
      System.out.println("ズーstationを見つけた！");
      int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
      int f=(int)(Math.random()*2);
      int e=(int)(Math.random()*2);
      System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
      // this.balls=this.balls+b;
      // this.fruits=this.fruits+f;
      add(f,b);
      if(e>=1){//卵を1つ以上Getしたら
        //egg[]に10個以上卵がない場合は新しい卵データをセットする
        for(int i=0;i<get_eggdistance_size();i++){
          if(get_egg(i)==false){
            egg.set(i,true);
            eggDistance.set(i,0.0);
            break;
        }
      }
    }
  }
  //
  // public void save_usermonster(int m){
  //   for(int j=0;j<userMonster.length;j++){
  //     if(this.userMonster[j]==null){
  //       this.userMonster[j]=this.monsterZukan.get(m);
  //       break;
  //     }
  //   }
  // }

  public Boolean get_egg(Integer i){
    return this.egg.get(i);
  }

  public Integer get_egg_size(){
    return this.egg.size();
  }

  public void add_eggdistance(Integer i){
    this.eggDistance.set(i,eggDistance.get(i)+1.0);
  }

  public void add_eggdistance_size(Integer i){
    this.eggDistance.size();
  }

  public Integer get_eggdistance_size(){
    return this.eggDistance.size();
  }

  public Double get_eggdistance(Integer i){
    return this.eggDistance.get(i);
  }

  public void sub_ball(){
    this.balls--;
  }

  public void add(int n, int j){
    this.fruits = this.fruits + n;
    this.balls = this.balls + j;
  }

  public void sub_fruits(){
    this.fruits--;
  }

  public void add_distance(){
    this.distance++;
  }

  public Double get_distance(){
    return this.distance;
  }

  public Integer get_balls(){
    return this.balls;
  }

  public Integer get_fruits(){
    return this.fruits;
  }
}
