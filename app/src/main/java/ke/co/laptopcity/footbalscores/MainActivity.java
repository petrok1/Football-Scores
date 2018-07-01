package ke.co.laptopcity.footbalscores;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Team team_A=new Team();
    private Team team_B=new Team();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fb=findViewById(R.id.fab);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               team_A.reset();
               team_B.reset();
               displayTeamA();
               displayTeamB();
            }
        });

    }

    public void Win(View view){
        switch (view.getId()){
            case R.id.win_team_a:
                team_A.win();
                displayTeamA();
                break;
            case R.id.win_team_b:
                team_B.win();
                displayTeamB();
                break;
        }
    }

    public void foul(View view){
        switch (view.getId()){
            case R.id.foul_team_a:
                team_A.foul();
                displayTeamA();
                break;
            case R.id.foul_team_b:
                team_B.foul();
                displayTeamB();
                break;
        }
    }

    public void draw(View view){
        team_A.points+=1;
        team_B.points+=1;
        displayTeamA();
        displayTeamB();
    }

    public void displayTeamA(){
        TextView points_a=(TextView)findViewById(R.id.team_a_points);
        TextView fouls_a=(TextView)findViewById(R.id.team_a_fouls);
        points_a.setText(""+team_A.points);
        fouls_a.setText(""+team_A.fouls);
    }

    public void displayTeamB(){
        TextView points_b=(TextView)findViewById(R.id.team_b_points);
        TextView fouls_b=(TextView)findViewById(R.id.team_b_fouls);
        points_b.setText(""+team_B.points);
        fouls_b.setText(""+team_B.fouls);
    }

    private class Team{
        public int points;
        public int fouls;

        public Team(){
            this.points=0;
            this.fouls=0;
        }

        public void win(){
            this.points+=3;
        }

        public void foul(){
            this.fouls+=1;
        }
        public void reset(){
            this.points=0;
            this.fouls=0;
        }
    }
}
