package com.dentitrack.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSlotScheduler {
    private static final LocalTime[] SLOT_TIMES = {
        LocalTime.of(9, 0),
        LocalTime.of(10, 0),
        LocalTime.of(11, 0),
        LocalTime.of(12, 0),
        LocalTime.of(14, 0),
        LocalTime.of(15, 0),
        LocalTime.of(16, 0),
        LocalTime.of(17, 0)
    };

    public static void main(String[] args) {
        LocalDate thirtiethDay = LocalDate.now().plusDays(30);
        addTimeSlotsForDate(thirtiethDay);
    }

    private static void addTimeSlotsForDate(LocalDate date) {
        String sql = "INSERT INTO timeslots (date, slot_time, is_booked) VALUES (?, ?, FALSE)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (LocalTime slotTime : SLOT_TIMES) {
                ps.setDate(1, java.sql.Date.valueOf(date));
                ps.setTime(2, java.sql.Time.valueOf(slotTime));
                ps.addBatch();
            }
            ps.executeBatch();
            System.out.println("Time slots for " + date + " added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
