#include "header.h"

extern char persnal_list[200][10][20];
extern char insurance_list[40][11][20];
extern int persnal_list_line;//0�`121
extern int insurance_list_line;//0�`38
extern char persnal_list_txt[];
extern char insurance_list_txt[];
extern int age_list[200][2];
extern int calculated_list[200][15];


//�l���X�g�t�@�C���ǂݍ���
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

		//EOF��
		if (c == EOF) {
			break;
		}

		//���s��
		else if (c == '\n') {
			persnal_list[x][y][z] = '\0';
			x++;
			y = 0;
			z = 0;
		}

		//�u,�v�u/�v��
		else if (c == ',' || c == '/') {
			persnal_list[x][y][z] = '\0';
			y++;
			z = 0;
		}
		//�������i�[
		else {
			persnal_list[x][y][z] = c;
			z++;
		}
		
	}

	//�t�@�C�������
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

		//EOF��
		if (c == EOF) {
			break;
		}

		//���s��
		else if (c == '\n') {
			insurance_list[x][y][z] = '\0';
			x++;
			y = 0;
			z = 0;
		}

		//�u/�v��
		else if (c == ',') {
			insurance_list[x][y][z] = '\0';
			y++;
			z = 0;
		}

		//�u0x81�v��
		else if ((unsigned char)c == 0x81){
			insurance_list[x][y][z] = '\0';
			y++;
			z = 0;
			c = fgetc(fp);//��ǂ�
		}

		//�������i�[
		else {
			insurance_list[x][y][z] = c;
			z++;
		}

	}

	//�t�@�C�������
	insurance_list_line = x;
	fclose(fp);
	return SUCCESS;
}
