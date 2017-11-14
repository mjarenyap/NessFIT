package mobapde.machineproject.nessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ExerciseList extends AppCompatActivity {

    DatabaseHelper dbHelper;
    LinearLayout homeNav, routineNav, exerciseNav, statusNav;
    LinearLayout cardioCategory, armsCategory, torsoCategory, legsCategory;
    ImageView cardioImage, armsImage, torsoImage, legsImage;
    RecyclerView exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        dbHelper = new DatabaseHelper(getBaseContext());
        populateExercise();

        System.out.println(dbHelper.getExercise(1));

        exerciseList = (RecyclerView) findViewById(R.id.rv_exercise_list);
        ExerciseAdapter exerciseAdapter = new ExerciseAdapter(getBaseContext(), dbHelper.getExercisesByCondition("Cardio"));
        exerciseList.setAdapter(exerciseAdapter);
        exerciseList.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        homeNav = (LinearLayout) findViewById(R.id.home_nav);
        routineNav = (LinearLayout) findViewById(R.id.routine_nav);
        exerciseNav = (LinearLayout) findViewById(R.id.exercise_nav);
        statusNav = (LinearLayout) findViewById(R.id.status_nav);

        cardioCategory = (LinearLayout) findViewById(R.id.cardio_category);
        armsCategory = (LinearLayout) findViewById(R.id.arms_category);
        torsoCategory = (LinearLayout) findViewById(R.id.torso_category);
        legsCategory = (LinearLayout) findViewById(R.id.legs_category);

        cardioImage = (ImageView) findViewById(R.id.cardio_icon);
        armsImage = (ImageView) findViewById(R.id.arms_icon);
        torsoImage = (ImageView) findViewById(R.id.torso_icon);
        legsImage = (ImageView) findViewById(R.id.legs_icon);

        exerciseAdapter.setOnItemClickListener(new ExerciseAdapter.OnItemClickListener(){
           @Override
           public void onItemClick(long currID){
               Intent i = new Intent();
               i.setClass(getBaseContext(), ExerciseActivity.class);
               i.putExtra("currID", currID);
               startActivity(i);
           }
        });

        cardioCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardioImage.setImageResource(R.drawable.cardio_active);
                armsImage.setImageResource(R.drawable.arms);
                torsoImage.setImageResource(R.drawable.torso);
                legsImage.setImageResource(R.drawable.legs);

                exerciseList.removeAllViewsInLayout();
                ExerciseAdapter exerciseAdapter = new ExerciseAdapter(getBaseContext(), dbHelper.getExercisesByCondition("Cardio"));
                exerciseList.setAdapter(exerciseAdapter);
                exerciseList.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                exerciseAdapter.setOnItemClickListener(new ExerciseAdapter.OnItemClickListener(){
                    @Override
                    public void onItemClick(long currID){
                        Intent i = new Intent();
                        i.setClass(getBaseContext(), ExerciseActivity.class);
                        i.putExtra("currID", currID);
                        startActivity(i);
                    }
                });
            }
        });

        armsCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardioImage.setImageResource(R.drawable.cardio);
                armsImage.setImageResource(R.drawable.arms_active);
                torsoImage.setImageResource(R.drawable.torso);
                legsImage.setImageResource(R.drawable.legs);

                exerciseList.removeAllViewsInLayout();
                ExerciseAdapter exerciseAdapter = new ExerciseAdapter(getBaseContext(), dbHelper.getExercisesByCondition("Arms"));
                exerciseList.setAdapter(exerciseAdapter);
                exerciseList.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                exerciseAdapter.setOnItemClickListener(new ExerciseAdapter.OnItemClickListener(){
                    @Override
                    public void onItemClick(long currID){
                        Intent i = new Intent();
                        i.setClass(getBaseContext(), ExerciseActivity.class);
                        i.putExtra("currID", currID);
                        startActivity(i);
                    }
                });
            }
        });

        torsoCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardioImage.setImageResource(R.drawable.cardio);
                armsImage.setImageResource(R.drawable.arms);
                torsoImage.setImageResource(R.drawable.torso_active);
                legsImage.setImageResource(R.drawable.legs);

                exerciseList.removeAllViewsInLayout();
                ExerciseAdapter exerciseAdapter = new ExerciseAdapter(getBaseContext(), dbHelper.getExercisesByCondition("Torso"));
                exerciseList.setAdapter(exerciseAdapter);
                exerciseList.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                exerciseAdapter.setOnItemClickListener(new ExerciseAdapter.OnItemClickListener(){
                    @Override
                    public void onItemClick(long currID){
                        Intent i = new Intent();
                        i.setClass(getBaseContext(), ExerciseActivity.class);
                        i.putExtra("currID", currID);
                        startActivity(i);
                    }
                });
            }
        });

        legsCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardioImage.setImageResource(R.drawable.cardio);
                armsImage.setImageResource(R.drawable.arms);
                torsoImage.setImageResource(R.drawable.torso);
                legsImage.setImageResource(R.drawable.legs_active);

                exerciseList.removeAllViewsInLayout();
                ExerciseAdapter exerciseAdapter = new ExerciseAdapter(getBaseContext(), dbHelper.getExercisesByCondition("Legs"));
                exerciseList.setAdapter(exerciseAdapter);
                exerciseList.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                exerciseAdapter.setOnItemClickListener(new ExerciseAdapter.OnItemClickListener(){
                    @Override
                    public void onItemClick(long currID){
                        Intent i = new Intent();
                        i.setClass(getBaseContext(), ExerciseActivity.class);
                        i.putExtra("currID", currID);
                        startActivity(i);
                    }
                });
            }
        });


        homeNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });

        routineNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), WeeklyActivity.class);
                startActivity(i);
            }
        });

        exerciseNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), ExerciseList.class);
                startActivity(i);
            }
        });

        statusNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), StatusActivity.class);
                startActivity(i);
            }
        });
    }

    public void populateExercise(){
        //dbHelper.resetTable(1);
        if(dbHelper.getAllExercises() == null){
            dbHelper.addExercise(new Exercise("Inchworm", "Stand with feet hip width and core tight. Bend from the waist, place hands on the ground, and walk hands forward, keeping legs straight. When you arrive in a high plank, quickly walk hands back toward feet and stand.", 1, "Cardio", "Beginner"));
            dbHelper.addExercise(new Exercise("Power Skip", "Stand with feet hip width and core tight. Raise right knee up as you bring left arm forward and hop off left foot. Land on the ball of your left foot then immediately bring right foot down and repeat on the other side. Focus on height not speed.", 2, "Cardio", "Beginner"));
            dbHelper.addExercise(new Exercise("Uppercut", "Stand in a split stance with right foot one step ahead of left foot and hips squared (facing forward). With right hand, punch up and to the left with a scooping motion. Quickly repeat on the other side. Continue to alternate as quickly as possible while maintaining loose knees and a tight core. Halfway through, switch stance to the other side.\n", 3, "Cardio", "Beginner"));
            dbHelper.addExercise(new Exercise("Mountain Climber Twist", "From a high plank position with core tight, run left knee in toward right elbow, then right knee in toward left elbow. Continue to alternate as quickly as possible without hiking hips.", 4, "Cardio", "Beginner"));
            dbHelper.addExercise(new Exercise("High Knees", "Stand with your feet hip width and run in place by pulling right knee up toward chest, then left knee up toward chest. Continue to alternate as quickly as possible.", 5, "Cardio", "Beginner"));
            dbHelper.addExercise(new Exercise("Punch", "Start in the same split stance that you used for uppercuts, with right foot one step ahead of left foot. Raise both fists up, keeping elbows pulled in to rib cage. Punch forward with left hand, slightly rotating torso as you do. Punch as quickly as possible for half of your time, then switch your stance and punch on the other side.", 6, "Cardio", "Beginner"));
            dbHelper.addExercise(new Exercise("Plank Jacks", "From a high plank position, with core tight, jump feet apart then jump them back together. Repeat as quickly as possible while trying to maintain level hips.", 7, "Cardio", "Beginner"));
            dbHelper.addExercise(new Exercise("Butt Kick", "Run in place kicking heels toward glutes. Swing arms at side or allow them to rest against butt so that heels kick palms. Make sure the movement is being driven from your hamstrings (not your feet kicking up dust).", 8, "Cardio", "Beginner"));
            dbHelper.addExercise(new Exercise("Fast Feet Shuffle", "With feet wider than hip width, bend knees slightly, sending hips back and keeping core tight. Shuffle feet to the right for 4 paces (or for as much space as you have), then shuffle back the other way. Stay low and make your feet move as quickly as possible to get the most out of this exercise.", 9, "Cardio", "Beginner"));
            dbHelper.addExercise(new Exercise("Plank-to-Knee Tap", "From a high plank position with core engaged, shift back and pike hips as you lift right hand to tap left shin (or ankle if you\'re extra flexible!). Return to high plank position and repeat on the other side. Move through the exercise as quickly as possible while maintaining good form.", 10, "Cardio", "Beginner"));

            dbHelper.addExercise(new Exercise("Arm Circles", "While standing straight with your feet flat on the ground and arms extended out to the side at a 90-degree angle to your body, start moving your arms in small, fast circles forward.", 11, "Arms", "Beginner"));
            dbHelper.addExercise(new Exercise("Tricep Dip", "While sitting on a chair, grip the edge of the seat with your hands and stretch your legs out in front of you. " +
                    "Move your body forward so that your feet are flat, your arms are bent behind you holding you up, and your body is extended above the ground. " +
                    "Slowly raise and lower your body using your triceps.", 12, "Arms", "Beginner"));
            dbHelper.addExercise(new Exercise("Inverted Row", "While sitting on a chair, grip the edge of the seat with your hands and stretch your legs out in front of you. " +
                    "Move your body forward so that your feet are flat, your arms are bent behind you holding you up, and your body is extended above the ground. " +
                    "Slowly raise and lower your body using your triceps.", 13, "Arms", "Beginner"));
            dbHelper.addExercise(new Exercise("Push-Ups", "Keep your feet together with your toes pointed down and your hands shoulder-width apart. The entire length of your body should run parallel to the ground. Your hips and back should be flat. " +
                    "This alignment needs to be maintained as you bend your elbows and lower your body to within an inch or so of the floor.", 14, "Arms", "Beginner"));
            dbHelper.addExercise(new Exercise("Pull-Ups", "To perform pull-ups correctly, place your hands shoulder-width apart on the horizontal bar. " +
                    "Next, raise your body until your chin is just over the bar's level. " +
                    "Then ease your body back down and repeat.", 15, "Arms", "Beginner"));
            dbHelper.addExercise(new Exercise("Plank", "Like a push-up, you will need to position your body horizontal to the ground, but keep your body in this position for 30 seconds or more to work your arms. " +
                    "Make sure your wrists are directly under your shoulders and your back is in a straight line.", 16, "Arms", "Beginner"));
            dbHelper.addExercise(new Exercise("Downward Dog", "For this pose, your body will form a reverse V-shape with your heels pressed down or close to the floor and your hands flat on the floor. Ideally, your spine will follow a straight line toward the ground with your hips pressed back. You may need to bend your knees to keep your body in the reverse V-shape. " +
                    "Use your arms to push your weight back toward your heels and make sure you\'re not rounding your back.", 17, "Arms", "Beginner"));
            /*dbHelper.addExercise(new Exercise("<Name>", "<Desc>", 18, "Arms", "Beginner"));
            dbHelper.addExercise(new Exercise("<Name>", "<Desc>", 19, "Arms", "Beginner"));
            dbHelper.addExercise(new Exercise("<Name>", "<Desc>", 20, "Arms", "Beginner"));*/

            dbHelper.addExercise(new Exercise("Crunch", "Lying flat on the ground with knees bent and hands behind the head, push lower back into the ground and lift upper back off the ground and slightly forward.", 21, "Torso", "Beginner"));
            dbHelper.addExercise(new Exercise("Vertical Leg Crunch", "Lie flat on the floor with lower back pressed to the ground. Place hands behind head. Extend legs straight up, crossed at the ankles with a slight bend in the knee. Contract abdominal muscles by lifting torso toward knees. Make sure to keep chin off your chest with each contraction. Exhale as you contract upward; inhale as you return to the starting position.", 22, "Torso", "Beginner"));
            dbHelper.addExercise(new Exercise("V-Ups", "Lie faceup with legs and arms extended. Keeping knees and elbows locked, simultaneously raise upper body and lower body while trying to touch fingers to toes.", 23, "Torso", "Beginner"));
            dbHelper.addExercise(new Exercise("Raised Knee-In", "Lie on back, arms along sides, palms down and just under lower back and butt. Press the small of your back against the floor and extend legs outward, with heels about 3 inches above the floor. Keeping lower back against the floor, lift left knee toward chest. Your right leg should remain hovering above the floor. Hold, then straighten left leg to the starting position and repeat with right leg.", 24, "Torso", "Beginner"));
            dbHelper.addExercise(new Exercise("Reverse Crunch", "Lie flat on the floor with lower back pressed to the ground. Place hands behind head or extend out alongside body. Crossing legs at ankles, lift feet up. Pull lower back off the floor as you contract abs. Reach legs toward the ceiling with each contraction.", 25, "Torso", "Beginner"));
            dbHelper.addExercise(new Exercise("Flutter Kicks", "Lie faceup with legs extended, toes pointed, and hands tucked underneath glutes to support lower back. Lift both legs off the floor a few inches and alternately kick legs up and down.", 26, "Torso", "Beginner"));
            dbHelper.addExercise(new Exercise("Side Plank", "Lie on side with lower arm bent at the elbow. Place lower elbow beneath shoulder and place upper hand on hip. Align ankles, hips, shoulders, and head. Push body toward the ceiling, balancing on the edge of your bottom shoe with one foot directly over the other.", 27, "Torso", "Beginner"));
            dbHelper.addExercise(new Exercise("Lying Side Crunch", "Lie on on your side with knees bent at a right angle and twisted to the left. Curl upper body, lifting shoulders off the floor a few inches. Pause at the top of the contraction and slowly lower back down. Switch sides and repeat.", 28, "Torso", "Beginner"));
            dbHelper.addExercise(new Exercise("Russian Twist", "Sit on the floor, knees bent and feet flat. Hold arms straight out in front of chest, with palms facing down. Lean back so that your torso is at a 45-degree angle to the floor. Twist to the right as far as you can, pause, then reverse movement and twist to the left.", 29, "Torso", "Beginner"));
            dbHelper.addExercise(new Exercise("Bicycle Kicks", "Lie on back with legs extended and hands folded across chest. Pull right knee in toward chest while twisting left shoulder toward right knee. Return to starting position and repeat with other knee and shoulder.", 30, "Torso", "Beginner"));

            dbHelper.addExercise(new Exercise("Bodyweight Squat", "Stand as tall as you can with your feet spread slightly wider than shoulder-width apart. Hold your arms straight out in front of your body at shoulder level, so that your arms parallel to the floor. Keep your torso as upright as you can for the entire movement, with your lower back slightly arched. Brace your abs, and lower your body as far as you can by pushing your hips back and bending your knees. Pause, then push yourself back to the starting position.", 31, "Legs", "Beginner"));
            dbHelper.addExercise(new Exercise("Warrior III", "Stand with the feet together, and lift up the left leg with a pointed toe, putting your body weight onto the standing, right leg. Continue to lift your leg and drop the head and torso so they form a straight horizontal line from head to toe with the arms at your sides. Engage your core and make sure the left thigh, hip, and toes are aligned. Remain facing down and keep your back as straight as possible. Ensure your right knee doesn't lock and center the weight on the middle of the foot.", 32, "Legs", "Beginner"));
            dbHelper.addExercise(new Exercise("Chair Squat", "Begin standing with your back to a chair, feet hip-width apart. While keeping your weight centered on your heels, draw in your abs and hinge forward at the hips slowly lowering your butt toward the chair. Pause right before you would sit down and return to standing while keeping the core engaged.", 33, "Legs", "Beginner"));
            dbHelper.addExercise(new Exercise("Pivoting Curtsy Lunge", "Standing with feet hip-width apart, step your right foot diagonally behind you and into a 7 o'clock position. Bend both knees so you're in a lunge stance. Lean your torso forward 30 degrees and pulse up and town 10-15 times. Straighten the body and pivot 180 degrees so your right foot comes to the front. Again, lower into a lunge.", 34, "Legs", "Beginner"));
            dbHelper.addExercise(new Exercise("Low Lunge Hover", "Stand with feet hip-width apart before stepping your right foot back, and lowering into lunge stance with the left knee over the ankle. Bring your arms over your head and hinge forward from the waist. Lower the chest forward toward the thighs as your arms reach forward. Lift the right leg while straightening the left. Hold for 3 breaths before returning to the starting lunge position.", 35, "Legs", "Beginner"));
            dbHelper.addExercise(new Exercise("Skater Lunge", "Begin with feet shoulder-width apart and the arms at your sides. Take a large step backwards with your left leg and cross it diagonally behind the right leg. Meanwhile, extend your right arm out to the side and swing the left arm across the hips. Hop about 2 feet to the left and come back to the beginning stance.", 36, "Legs", "Beginner"));
            dbHelper.addExercise(new Exercise("The Lean", "Begin with feet shoulder-width apart and the arms down at your sides. Take a step diagonally back with the right foot. Then, bend sideways from the waist toward the side where your right leg is stretched out, and reach your right arm up and left arm down and back toward your right calf.", 37, "Legs", "Beginner"));
            dbHelper.addExercise(new Exercise("Leg Lift", "While you stand facing a chair, raise your right leg, knee facing up, foot flexed and place your heel on the seat. Make sure not to lock your standing knee as you lift your right foot off the chair and straighten it out until you feel your quadriceps engage. Keeping your lifted leg in the air, bend the leg on the floor slightly and then straighten it again.", 38, "Legs", "Beginner"));
            dbHelper.addExercise(new Exercise("Two-Thirds Jump Squat", "Begin by standing with feet shoulder-width apart, arms at the sides. Lower the body into a squat, going two-thirds of the way down. Immediately jump straight up with your arms pointed up toward the ceiling.", 39, "Legs", "Beginner"));
            dbHelper.addExercise(new Exercise("V-Position", "Stand holding the back of a chair with one hand. Place your feet in a V position, toes should be about 4 inches apart and heels stay pressed together. Bend your knees and lift the heels a few inches off the floor. Then, lower your hips until you feel your quads intensely working. Pulse up and down.", 40, "Legs", "Beginner"));
        }
    }
}