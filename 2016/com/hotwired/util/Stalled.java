package com.revAmped.util;

/**
 * Created by zwang on 9/2/2015.
 */
public class Stalled
{
    private int m_lastEncoder = 0;
    private long m_lastTimeStamp = 0;;

    public void reset ()
    {
        m_lastTimeStamp = 0;
    }

    /**
     * whether motor is stalled.
     * @param encoder encoder value
     * @param timeStamp current time stamp
     * @return true if is stalled, false if not
     */
    public boolean isStalled(int encoder, long timeStamp)
    {
        final int STALLED_MILLI = 250;
        boolean stalled = false;
        if (m_lastTimeStamp == 0)
        {
            m_lastTimeStamp = timeStamp;
        }
        else if (Math.abs(encoder - m_lastEncoder) >= 4) {
            m_lastTimeStamp = timeStamp;
        }

        if (Math.abs(timeStamp - m_lastTimeStamp) >= STALLED_MILLI) {
            m_lastTimeStamp = timeStamp;
            stalled = true;
            HwLog.e("Motor stalled");
        }

        m_lastEncoder = encoder;
        return stalled;
    }
}
