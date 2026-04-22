package com.udong.entity_audit_log_annotation.lib.helper;

import com.udong.entity_audit_log_annotation.lib.annotations.Mask;

import java.util.concurrent.ThreadLocalRandom;

public class MaskDataUtil {
    private MaskDataUtil() {

    }

    public static String getMaskedField(Mask mask) {
        int min = mask.min();
        int max = mask.max();
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max);

        return mask.maskWith().repeat(randomNumber);
    }
}
