import java.util.ArrayList;

public class MonsterZoo {
	// double distance=0.0;//歩いた距離
	// int balls=10;//モンスターを捕まえられるボールの数
	// int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ
	static NumberingManeger number_maneger = new NumberingManeger();
	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	// double eggDistance[] = new double[9];
	// boolean egg[] = new boolean[9];

	//ユーザがGetしたモンスター一覧
	String userMonster[] = new String[100];

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	// String monsterZukan[] = new String[22];
	// double monsterRare[] = new double[22];
	ArrayList<String> monsterZukan = new ArrayList<String>();
	ArrayList<Integer> monsterRare = new ArrayList<Integer>();

	//呼び出すと1km distanceが増える
	void move(){
		// this.distance++;
		number_maneger.add_distance();
		for(int i=0;i<number_maneger.get_egg_size();i++){//卵は移動距離が進むと孵化するため，何km移動したかを更新する
			if(number_maneger.get_egg(i)==true){
				number_maneger.add_eggdistance(i);
			}
		}

		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
		if(flg1<=1){
			number_maneger.ball_and_fruit_and_egg_get();
		}else if(flg1>=7){
			monster_meet_and_battle();
		}
		monster_bone();
	}

	void monster_meet_and_battle(){
		int m = (int)(this.monsterZukan.size()*Math.random());//monsterZukanからランダムにモンスターを出す
		System.out.println(this.monsterZukan.get(m)+"が現れた！");
		for(int i=0;i<3&&number_maneger.get_balls()>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
			int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
			fruits_throw(r);
			System.out.println(this.monsterZukan.get(m)+"にボールを投げた");
			// this.balls--;
			number_maneger.sub_ball();
			if (escapte_or_catch(r, m)){
				break;
			}
		}
	}

	public Boolean escapte_or_catch(int r, int m){
		if(this.monsterRare.get(m)<=r){//monsterRare[m]の値がr以下の場合
			System.out.println(this.monsterZukan.get(m)+"を捕まえた！");
			save_usermonster(m);
			// break;//ボール投げ終了
			return true;
		}else{
			System.out.println(this.monsterZukan.get(m)+"に逃げられた！");
			return false;
		}
	}

	public Boolean fruits_throw(Integer r){
		if(number_maneger.get_fruits()>0){
			System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
			number_maneger.sub_fruits();
			return true;
		}
		return false;
	}

	void monster_bone(){
		for(int i=0;i<number_maneger.get_egg_size();i++){
			if(number_maneger.get_egg(i)==true&&number_maneger.get_eggdistance(i)>=3){
				System.out.println("卵が孵った！");
				int m = (int)(this.monsterZukan.size()*Math.random());
				System.out.println(this.monsterZukan.get(m)+"が産まれた！");
				save_usermonster(m);
				number_maneger.egg.set(i,false);
				number_maneger.eggDistance.set(i,0.0);
			}
		}
	}

	public void save_usermonster(int m){
		for(int j=0;j<userMonster.length;j++){
			if(this.userMonster[j]==null){
				this.userMonster[j]=this.monsterZukan.get(m);
				break;
			}
		}
	}

	public double getDistance() {
		return this.number_maneger.get_distance();
	}

	public int getBalls() {
		return this.number_maneger.get_balls();
	}

	public int getFruits() {
		return this.number_maneger.get_fruits();
	}

	public String[] getUserMonster() {
		return userMonster;
	}

	public void setMonsterZukan(ArrayList<String> monsterZukan) {
		this.monsterZukan = monsterZukan;
	}

	public void setMonsterRare(ArrayList<Integer> monsterRare) {
		this.monsterRare = monsterRare;
	}
}
