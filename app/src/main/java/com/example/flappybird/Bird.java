package com.example.flappybird;

import android.graphics.Rect;

public class Bird {

    private static final float GRAVITY_PULL = 1.5f;
    private static final float FLAP_UPWARD_FORCE = -20f;
    private static final int HITBOX_PADDING = 5;

    private int x;
    private int y;
    private final int width;
    private final int height;

    private float currentVerticalVelocity;
    private final Rect hitbox;

    public Bird(int initialX, int initialY, int birdWidth, int birdHeight) {
        this.x = initialX;
        this.y = initialY;
        this.width = birdWidth;
        this.height = birdHeight;
        this.currentVerticalVelocity = 0f;
        this.hitbox = new Rect();

        updateHitboxPosition();
    }

    public void update() {
        applyGravity();
        updateVerticalPosition();
        updateHitboxPosition();
    }

    public void flap() {
        currentVerticalVelocity = FLAP_UPWARD_FORCE;
    }

    private void applyGravity() {
        currentVerticalVelocity += GRAVITY_PULL;
    }

    private void updateVerticalPosition() {
        y += (int) currentVerticalVelocity;
    }

    private void updateHitboxPosition() {
        int leftEdge = x + HITBOX_PADDING;
        int topEdge = y + HITBOX_PADDING;
        int rightEdge = (x + width) - HITBOX_PADDING;
        int bottomEdge = (y + height) - HITBOX_PADDING;

        hitbox.set(leftEdge, topEdge, rightEdge, bottomEdge);
    }

    public Rect getHitbox() {
        return hitbox;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}