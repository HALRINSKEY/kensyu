#include "header.h"

extern char persnal_list[200][10][20];
extern char insurance_list[40][11][20];
extern int persnal_list_line;
extern int insurance_list_line;
extern char persnal_list_txt[];
extern char insurance_list_txt[];
extern int age_list[200][2];
extern int calculated_list[200][15];

void age_calc() {
	int dyaer = 0;//Œo‰ß”N
	int dmonth = 0;//Œo‰ßŒ
	int dday = 0;//Œo‰ß“ú
	int year = 0;//’a¶”N
	int month = 0;//’a¶Œ
	int day = 0;//’a¶“ú

	for (int i = 0; persnal_list_line > i; i++) {

		//ŒÂlƒŠƒXƒg‚Ì’a¶”NAŒ,“ú‚ğ”’l‰»
		year = atoi(&persnal_list[i][3]);
		month = atoi(&persnal_list[i][4]);
		day = atoi(&persnal_list[i][5]);

		//Œo‰ß”N‚ÆŒo‰ßŒ‚ğZo
		dyaer = 2005 - year;

		if (month <= 4) {
			dmonth = 4 - month;
		}
		else {
			dyaer--;
			dmonth = 12 + 4 - month;
		}

		if (day <= 5) {
			dday = 5 - day;
		}
		else {
			dmonth--;
			dday = 30 + 5 - day;
		}

		dmonth += dday / 30;
		dyaer += dmonth / 12;
		

		//Œo‰ß”NAŒ‚ğŠi”[
		age_list[i][0] = dyaer;
		age_list[i][1] = dmonth;
	}
}

void calc() {
	//Ğ‰ï•ÛŒ¯•ñVŒŠz‚Ì”’l‰»
	int serach_insurance[40];
	int calc_list_line;
	int grade_line;

	for (int i = 0; insurance_list_line > i; i++) {
		serach_insurance[i] = atoi(&insurance_list[i][3]);//Ši”[
	}

	//ŒvZˆ—
	for (int calc_list_line = 0; persnal_list_line > calc_list_line; calc_list_line++) {

		//Šî–{c‹Æ’Ê‹Î”’l‰»AŠi”[
		for (int i = 0; 3 > i; i++) {// n:0 Šî–{@n:1 c‹Æ@n:2 ’Ê‹Î
			calculated_list[calc_list_line][i] = atoi(&persnal_list[calc_list_line][i + 6]);//calculated_list[s][—ñ]
		}

		//x‹‹‡ŒvŠi”[
		calculated_list[calc_list_line][3] = calculated_list[calc_list_line][0] + calculated_list[calc_list_line][1] + calculated_list[calc_list_line][2];

		//“™‹‰ŒŸõ
		for (int i = 0; insurance_list_line - 1 > i; i++) {
			if (serach_insurance[i] > calculated_list[calc_list_line][3]) {
				grade_line = i;
				break;
			}
			grade_line = 38;

		}

		//Œ’N•ÛŒ¯Ši”[
		if (age_list[calc_list_line][0] < 40) {

		//‰îŒì•ÛŒ¯”ñŠY“–
			calculated_list[calc_list_line][4] = (int)(atof(&insurance_list[grade_line][5]) + 0.49);//calculated_list[s][—ñ] ŒÂl•‰’SŒ’N•ÛŒ¯
			calculated_list[calc_list_line][9] = (int)(atof(&insurance_list[grade_line][5]) + 0.49);//calculated_list[s][—ñ] ‰ïĞ•‰’SŒ’N•ÛŒ¯
		}
		else {

		//‰îŒì•ÛŒ¯ŠY“–
			calculated_list[calc_list_line][4] = (int)(atof(&insurance_list[grade_line][7]) + 0.49);//calculated_list[s][—ñ] ŒÂl•‰’SŒ’N•ÛŒ¯
			calculated_list[calc_list_line][9] = (int)(atof(&insurance_list[grade_line][7]) + 0.49);//calculated_list[s][—ñ] ‰ïĞ•‰’SŒ’N•ÛŒ¯
		}

		//Œú¶”N‹à”’l‰»AŠi”[
		calculated_list[calc_list_line][5]  = (int)(atof(&insurance_list[grade_line][9]) + 0.49);//calculated_list[s][—ñ] ŒÂl•‰’SŒú¶”N‹à
		calculated_list[calc_list_line][10] = (int)(atof(&insurance_list[grade_line][9]) + 0.49);//calculated_list[s][—ñ] ‰ïĞ•‰’SŒú¶”N‹à

		//ŒÙ—p•ÛŒ¯”’l‰»AŠi”[
		calculated_list[calc_list_line][6] = calculated_list[calc_list_line][3] * 7 / 1000;//ŒÂl•‰’SŒÙ—p•ÛŒ¯
		calculated_list[calc_list_line][11] = calculated_list[calc_list_line][3] * 11 / 1000;//Šé‹Æ•‰’SŒÙ—p•ÛŒ¯

		//˜JĞ•ÛŒ¯
		calculated_list[calc_list_line][12] = calculated_list[calc_list_line][3] * 5 / 1000;

		//™“¶è“–
		calculated_list[calc_list_line][13] = (int)atof(insurance_list[grade_line][10]);//™“¶è“–Ši”[

		//TœŒv
		calculated_list[calc_list_line][7] = calculated_list[calc_list_line][4] + calculated_list[calc_list_line][5] + calculated_list[calc_list_line][6];

		//‘x‹‹
		calculated_list[calc_list_line][8] = calculated_list[calc_list_line][3] - calculated_list[calc_list_line][7];

		//˜J–±”ï
		calculated_list[calc_list_line][14] = calculated_list[calc_list_line][3] + calculated_list[calc_list_line][9] + calculated_list[calc_list_line][10] + calculated_list[calc_list_line][11] + calculated_list[calc_list_line][12] + calculated_list[calc_list_line][13];
	}
}
