package com.example.flappybird;

import android.graphics.Point;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Lấy kích thước của màn hình điện thoại
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        // 2. Khởi tạo GameView với kích thước vừa lấy
        gameView = new GameView(this, point.x, point.y);

        // 3. Đưa GameView lên màn hình (Thay thế hoàn toàn file XML cũ)
        setContentView(gameView);
    }

    // --- Hai hàm dưới đây vô cùng quan trọng để vòng lặp Game hoạt động ---
    @Override
    protected void onPause() {
        super.onPause();
        // Dừng vẽ khi người dùng thoát ra màn hình chính điện thoại
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Tiếp tục vòng lặp vẽ 60FPS khi người dùng mở lại app
        gameView.resume();
    }
}