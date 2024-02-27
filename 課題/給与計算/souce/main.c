
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
char persnal_list_txt[] =	"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\���^�v�Z\\souce\\�l���X�g.txt";
char insurance_list_txt[] = "C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\���^�v�Z\\souce\\�Љ�ی����z�\.txt";
char default_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\���^�v�Z\\souce\\�o��\\���^���X�g.txt";
char onlyman_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\���^�v�Z\\souce\\�o��\\���^���X�g�j��.txt";
char onlywoman_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\���^�v�Z\\souce\\�o��\\���^���X�g����.txt";
char costup_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\���^�v�Z\\souce\\�o��\\�J�����.txt";
char costdown_file[] =		"C:\\Users\\HARUTO YOKOGOSHI\\Desktop\\���^�v�Z\\souce\\�o��\\�J����~��.txt";


main() {
	//�l���X�g���́@SUCCEES:0 FALSE:-1
	if (persnal_list_input() == -1) {
		printf("�l���X�g���J���܂���\n");
		exit(0);
	}

	//�Љ�ی����z���́@SUCCEES:0 FALSE:-1
	if (insurance_list_input() == -1) {
		printf("�Љ�ی����z���X�g���J���܂���\n");
		exit(0);
	}

	//�v�Z����
	age_calc();
	calc();

	//���X�g�쐬
	make_default_list();
	make_only_list();
	make_up_list();
	make_down_list();

	//�o��
	if (output(default_file, default_list) == -1) {
		printf("%s���������߂܂���\n",default_file);
		exit(0);
	}
	//�j
	if (output(onlyman_file, only_man_list) == -1) {
		printf("%s���������߂܂���\n", onlyman_file);
		exit(0);
	}
	//��
	if (output(onlywoman_file, only_woman_list) == -1) {
		printf("%s���������߂܂���\n", onlywoman_file);
		exit(0);
	}
	//����
	if (output(costup_file, cost_up_list) == -1) {
		printf("%s���������߂܂���\n", costup_file);
		exit(0);
	}
	//�~��
	if (output(costdown_file, cost_down_list) == -1) {
		printf("%s���������߂܂���\n", costdown_file);
		exit(0);
	}

}

