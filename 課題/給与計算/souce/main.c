
#include "header.h"


char persnal_list[200][10][20];
char insurance_list[40][11][20];
int persnal_list_line;
int insurance_list_line;
int age_list[200][2];
int calculated_list[200][15];
int default_list[200];
int only_man_list[200];
int only_woman_list[200];
int cost_up_list[200];
int cost_down_list[200];
char persnal_list_txt[] =	"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\給与計算\\souce\\個人リスト.txt";
char insurance_list_txt[] = "C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\給与計算\\souce\\社会保険月額表.txt";
char default_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\給与計算\\souce\\出力\\給与リスト.txt";
char onlyman_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\給与計算\\souce\\出力\\給与リスト男性.txt";
char onlywoman_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\給与計算\\souce\\出力\\給与リスト女性.txt";
char costup_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\給与計算\\souce\\出力\\労務費昇順.txt";
char costdown_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\給与計算\\souce\\出力\\労務費降順.txt";


main() {
	//個人リスト入力　SUCCEES:0 FALSE:-1
	if (persnal_list_input() == -1) {
		printf("個人リストが開けません\n");
		exit(0);
	}

	//社会保険月額入力　SUCCEES:0 FALSE:-1
	if (insurance_list_input() == -1) {
		printf("社会保険月額リストが開けません\n");
		exit(0);
	}

	//計算処理
	age_calc();
	calc();

	//リスト作成
	make_default_list();
	make_only_list();
	make_up_list();
	make_down_list();

	//出力
	if (output(default_file, default_list) == -1) {
		printf("%sが書き込めません\n",default_file);
		exit(0);
	}
	//男
	if (output(onlyman_file, only_man_list) == -1) {
		printf("%sが書き込めません\n", onlyman_file);
		exit(0);
	}
	//女
	if (output(onlywoman_file, only_woman_list) == -1) {
		printf("%sが書き込めません\n", onlywoman_file);
		exit(0);
	}
	//昇順
	if (output(costup_file, cost_up_list) == -1) {
		printf("%sが書き込めません\n", costup_file);
		exit(0);
	}
	//降順
	if (output(costdown_file, cost_down_list) == -1) {
		printf("%sが書き込めません\n", costdown_file);
		exit(0);
	}

}

