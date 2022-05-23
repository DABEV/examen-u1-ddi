package dao

import bean.ProgramingCourse

class ProgramingCourseDao(val list : MutableList<ProgramingCourse> = mutableListOf<ProgramingCourse>()) {
    fun add(course: ProgramingCourse): Boolean{
        if(get(course.id) == null){
            list.add(course)
            return true
        }
        return false;
    }

    fun get(id: Int): ProgramingCourse? {
        for (course in list){
            if (course.id.equals(id)){
                return course
            }
        }
        return null
    }

    fun delete(id: Int): Boolean{
        val course = get(id);
        if (course != null){
            list.remove(course)
            return true
        }

        return false
    }

    fun update(course: ProgramingCourse): Boolean{
        val courseOld: ProgramingCourse? = get(course.id);
        if (courseOld != null){
            courseOld.name = course.name
            courseOld.description = course.description

            list[course.id] = courseOld
            return true
        }
        return false
    }
}