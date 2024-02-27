#include "header.h"

extern char persnal_list[200][10][20];
extern int calculated_list[200][15];
extern int age_list[200][2];
extern char default_file[];
extern int persnal_list_line;
extern int default_list[200];
extern int only_man_list[200];
extern int only_woman_list[200];
extern int cost_up_list[200];
extern int cost_down_list[200];

int output(char *filename, int *list_array) {//(出力するファイル名、　出力するファイルの行)
	int calculated_list_sum[15] = {0};

	//ファイルオープン
	FILE* fp;
	errno_t err;

	err = fopen_s(&fp, filename, "w");
	if (err != 0) {
		return FAILURED;
	}

	//1レコード目書き込み
	fputs("個人情報,,,,個人給与,,,,,,,,,会社労務費\n", fp);

	//2レコード目書き込み
	fputs("ＮＯ,氏名,性別,年齢／月,基本,残業,通勤,支給合計,健康保険,厚生年金,雇用保険,控除,総支給,健康保険,厚生年金,雇用保険,労災保険,育児手当,労務費\n", fp);
	
	
	for (; *list_array >= 0; list_array++) {
		//NO書き込み
		fprintf(fp, "%04d,", atoi(&persnal_list[*list_array][0]));

		//名前書き込み
		fprintf(fp, "%s,", persnal_list[*list_array][1]);

		//性別

		if (persnal_list[*list_array][2][0] == '1') {
			fprintf(fp, "男,");
		}
		else {
			fprintf(fp, "女,");
		}

		//年齢経過月
		fprintf(fp, "%02d/%02d", age_list[*list_array][0], age_list[*list_array][1]);

		//計算処理結果書き込み
		for (int i = 0; 15 > i; i++) {
			fprintf(fp, ",%d", calculated_list[*list_array][i]);

			calculated_list_sum[i] += calculated_list[*list_array][i];
		}

		fprintf(fp, "\n");
	}

	//末尾レコード
	fprintf(fp, "合計,,,");

	//合計を書き込む
	for (int i = 0; 15 > i; i++) {
		fprintf(fp, ",%d", calculated_list_sum[i]);
	}
	fprintf(fp, "\n");
	

	//ファイルを閉じる
	fclose(fp);
	return SUCCESS;
}

void make_default_list() {
	//順番のリスト作成
	int i;
	for (i = 0; persnal_list_line > i; i++) {
		default_list[i] = i;
	}

	default_list[i] = -1;
}

void make_only_list() {
	int man_index = 0;
	int woman_index = 0;


	for (int i = 0; persnal_list_line > i; i++) {
		if (persnal_list[i][2][0] == '1') {
			//男リスト
			only_man_list[man_index] = i;
			man_index++;
		}
		else {
			//女リスト
			only_woman_list[woman_index] = i;
			woman_index++;
		}
	}

	only_man_list[man_index] = -1;
	only_woman_list[woman_index] = -1;

}

void make_up_list() {
	int temp_list[122][2];
	int temp = 0;
	int sorttimes = persnal_list_line - 1;
	int cost_index;

	for (int i = 0; persnal_list_line > i; i++) {
		temp_list[i][0] = i;
		temp_list[i][1] = calculated_list[i][14];
	}

	//昇順ソート
	for (int i = 0; sorttimes > i; i++) {
		for (int j = sorttimes; j > i; j--) {
			if (temp_list[j - 1][1] > temp_list[j][1]) {
				temp = temp_list[j][1];
				temp_list[j][1] = temp_list[j - 1][1];
				temp_list[j - 1][1] = temp;

				temp = temp_list[j][0];
				temp_list[j][0] = temp_list[j - 1][0];
				temp_list[j - 1][0] = temp;
			}
		}
	}

	for (cost_index = 0; persnal_list_line > cost_index; cost_index++) {
		cost_up_list[cost_index] = temp_list[cost_index][0];
	}

	cost_up_list[cost_index] = -1;

}

void make_down_list() {
	int temp_list[122][2];
	int temp = 0;
	int sorttimes = persnal_list_line - 1;
	int cost_index;

	for (int i = 0; persnal_list_line > i; i++) {
		temp_list[i][0] = i;
		temp_list[i][1] = calculated_list[i][14];
	}

	//降順ソート
	for (int i = 0; sorttimes > i; i++) {
		for (int j = sorttimes; j > i; j--) {
			if (temp_list[j - 1][1] < temp_list[j][1]) {
				temp = temp_list[j][1];
				temp_list[j][1] = temp_list[j - 1][1];
				temp_list[j - 1][1] = temp;

				temp = temp_list[j][0];
				temp_list[j][0] = temp_list[j - 1][0];
				temp_list[j - 1][0] = temp;
			}
		}
	}

	for (cost_index = 0; persnal_list_line > cost_index; cost_index++) {
		cost_down_list[cost_index] = temp_list[cost_index][0];
	}

	cost_down_list[cost_index] = -1;

}