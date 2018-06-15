package com.ab.builderPattern_DesingPattern;

public class Job {
    
	//madatory fields
	private final String knowledge;
	private final String attitude;
	
	//optional fields
	private final String extraTallented;
	private final String wellSettledFamily;
	private final String rich;
	
	//inner class
	public static class JobInnerClass  {
		
		private String innerClassKnowledge;
		private String innerClassAttitude;
		private String innerClassExtraTallented;
		private String innerClassWellSettledFamily;
		private String innerClassRich;
		
		public JobInnerClass(String knowledge , String attitude){
			this.innerClassKnowledge = knowledge;//
			this.innerClassAttitude = attitude;
		}
		
		public JobInnerClass setExtraTallented(String extraTallented) {
			this.innerClassExtraTallented = extraTallented ;
			return this;
		}
		public JobInnerClass setWellSettledFamily(String wellSettledFamily) {
			this.innerClassWellSettledFamily = wellSettledFamily ;
			return this;
		}
		public JobInnerClass setRich(String rich) {
			this.innerClassRich = rich;
			return this;
		}
		
		
		
		public Job build() {
			return new Job(this);
		}
	}//JobInnerClass
	
	//constructor
			private Job(JobInnerClass icj) {
				this.knowledge = icj.innerClassKnowledge;
				this.attitude = icj.innerClassAttitude;
				this.extraTallented = icj.innerClassExtraTallented;
				this.wellSettledFamily = icj.innerClassWellSettledFamily;
				this.rich = icj.innerClassRich;
			}//constructor of Job

			@Override
			public String toString() {
				return " [knowledge = " + knowledge + " , attitude = " + attitude + " , extraTallented = " + extraTallented
						+ " , wellSettledFamily = " + wellSettledFamily + " , rich = " + rich + "]";
			}
			
			
	
}//Job
