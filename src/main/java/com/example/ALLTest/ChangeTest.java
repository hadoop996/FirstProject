package com.example.ALLTest;

/**
 * @author 郝少杰
 * @date 2021/1/25 20:17
 */
public class ChangeTest {
    public static void main(String[] args) {
        String[] a = {"t_area","t_area_info","t_channel","t_channel_developing_person","t_channel_info","t_department_info",
                "t_engineer_administrator","t_engineer_administrator_upload_fail","t_engineers_team","t_engineers_team_upload_fail",
                "t_engineer_team_member","d_evaluate_report","t_install_person","d_install_sucess_report","t_install_person_temporary",
                "t_score_ratio_day","t_score_ratio_month","t_score_ratio_week","t_score_result_day","t_score_result_month","t_score_result_week",
                "t_smart_engineer_avg_time_distribution_config", "t_smart_engineer_summary_report_month","t_smart_engineer_summary_report_week","t_staff_employees_info",
                "trade_daily_vdoing","t_user_engineer_rel","t_user_engineer_rel_upload_fail"};
        for (int i=0;i<a.length;i++){
            String b = "mysqldump  -h 10.238.10.73 -P 3306 -u udbh --set-gtid-purged=off -p udbh -d  --tables t_area >/tmp/sql/smart/t_area.sql";
            System.out.println(b.replaceAll("t_area",a[i]));
        }
    }
}
