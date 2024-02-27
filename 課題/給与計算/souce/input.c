#include "header.h"

extern char persnal_list[200][10][20];
extern char insurance_list[40][11][20];
extern int persnal_list_line;//0～121
extern int insurance_list_line;//0～38
extern char persnal_list_txt[];
extern char insurance_list_txt[];
extern int age_list[200][2];
extern int calculated_list[200][15];


//個人リストファイル読み込み
int persnal_list_input() {
	char c;
	int x = 0;
	int y = 0;
	int z = 0;

	FILE* fp;
	errno_t err;

	err = fopen_s(&fp, persnal_list_txt, "r");
	if (err != 0) {
		return FAILURED;
	}

	while (1) {
		c = fgetc(fp);

		//EOFか
		if (c == EOF) {
			break;
		}

		//改行か
		else if (c == '\n') {
			persnal_list[x][y][z] = '\0';
			x++;
			y = 0;
			z = 0;
		}

		//「,」「/」か
		else if (c == ',' || c == '/') {
			persnal_list[x][y][z] = '\0';
			y++;
			z = 0;
		}
		//文字を格納
		else {
			persnal_list[x][y][z] = c;
			z++;
		}
		
	}

	//ファイルを閉じる
	persnal_list_line = x;
	fclose(fp);
	return SUCCESS;
}

int insurance_list_input() {
	char c;
	int x = 0;
	int y = 0;
	int z = 0;

	FILE* fp;
	errno_t err;

	err = fopen_s(&fp, insurance_list_txt, "r");
	if (err != 0) {
		return FAILURED;
	}

	while (1) {
		c = fgetc(fp);

		//EOFか
		if (c == EOF) {
			break;
		}

		//改行か
		else if (c == '\n') {
			insurance_list[x][y][z] = '\0';
			x++;
			y = 0;
			z = 0;
		}

		//「/」か
		else if (c == ',') {
			insurance_list[x][y][z] = '\0';
			y++;
			z = 0;
		}

		//「0x81」か
		else if ((unsigned char)c == 0x81){
			insurance_list[x][y][z] = '\0';
			y++;
			z = 0;
			c = fgetc(fp);//空読み
		}

		//文字を格納
		else {
			insurance_list[x][y][z] = c;
			z++;
		}

	}

	//ファイルを閉じる
	insurance_list_line = x;
	fclose(fp);
	return SUCCESS;
}
