package com.nt.weixinapp.message.face.pojo;

public class Eyestatus {
/*
left_eye_status：左眼的状态
right_eye_status：右眼的状态
每个属性都包含以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。字段值的总和等于 100。

occlusion：眼睛被遮挡的置信度
no_glass_eye_open：不戴眼镜且睁眼的置信度
normal_glass_eye_close：佩戴普通眼镜且闭眼的置信度
normal_glass_eye_open：佩戴普通眼镜且睁眼的置信度
dark_glasses：佩戴墨镜的置信度
no_glass_eye_close：不戴眼镜且闭眼的置信度
	
	*/
	
	private LeftEyeStatus left_eye_status;
	private RightEyeStatus right_eye_status;
	public LeftEyeStatus getLeft_eye_status() {
		return left_eye_status;
	}
	public void setLeft_eye_status(LeftEyeStatus left_eye_status) {
		this.left_eye_status = left_eye_status;
	}
	public RightEyeStatus getRight_eye_status() {
		return right_eye_status;
	}
	public void setRight_eye_status(RightEyeStatus right_eye_status) {
		this.right_eye_status = right_eye_status;
	}
	@Override
	public String toString() {
		return "Eyestatus [left_eye_status=" + left_eye_status + ", right_eye_status=" + right_eye_status + "]";
	}
	
}
