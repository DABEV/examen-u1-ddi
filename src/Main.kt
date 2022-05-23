import bean.CookingCourse
import bean.ProgramingCourse
import dao.CookingCourseDao
import dao.ProgramingCourseDao

class Main {
    companion object {
        const val MSG_SUCCESS = "Se ha realizado la operación correctamente"
        const val MSG_ERROR = "Ha ocurrido un error"
    }

    var idCooking : Int = 1
    var idProgramming : Int = 1
    fun readLn() = readLine()!!
    fun readInt() = readLn().toInt()
    fun readCourse () : List<String> {
        println("Dime el nombre del curso: ")
        val name = readLn()
        println("Dime la descripción del curso: ")
        val description = readLn()

        return listOf(name, description)
    }

    var cookingCourses: CookingCourseDao = CookingCourseDao()
    var programingCourses: ProgramingCourseDao = ProgramingCourseDao()
}

fun main(args: Array<String>) {
    var main = Main()
    println("Cursos :D")
    do {
        println("Opciones disponibles")
        println("1 -> Cursos de cocina")
        println("2 -> Cursos de programación")
        println("3 -> Listar Todos")
        println("4 -> Salir :C")
        println("Ingrese una opción")
        var opc: Int = main.readInt()
        when (opc) {
            1 -> {
                println("\nCursos de cocina")
                do {
                    var course: CookingCourse? = null
                    println("1 -> Add")
                    println("2 -> Update")
                    println("3 -> Delete")
                    println("4 -> Get")
                    println("5 -> Regresar al menú principal :Dd")
                    println("Ingrese una opción:")
                    var opc: Int = main.readInt()
                    when (opc) {
                        1 -> {
                            val (name, description) = main.readCourse()
                            course = CookingCourse(main.idCooking++, name, description)

                            if (main.cookingCourses.add(course)) {
                                println(Main.MSG_SUCCESS)
                            } else println(Main.MSG_ERROR)
                        }
                        2 -> {
                            println("Ingresa el id del curso que deseas actualizar: ")
                            var id = main.readInt()
                            var course = main.cookingCourses.get(id)
                            if (course != null) {

                                val (name, description) = main.readCourse()
                                course.name = name
                                course.description = description

                                if (main.cookingCourses.update(course)) println(Main.MSG_SUCCESS)
                                else Main.MSG_ERROR
                            } else println(Main.MSG_ERROR)
                        }
                        3 -> {
                            println("Ingresa el id del curso que deseas eliminar: ")
                            var id = main.readInt()

                            if (main.cookingCourses.delete(id)) println(Main.MSG_SUCCESS)
                            else Main.MSG_ERROR
                        }
                        4 -> {
                            println("Lista de Cursos de Cocina")
                            for (c in main.cookingCourses.list)
                                println("${c.id}.- ${c.name} - ${c.description}")
                        }

                        else -> println("Opción inexistente :CCC")
                    }
                } while (opc != 5)
            }
            2 -> {
                println("\nCursos de programación")
                do {
                    var course: ProgramingCourse? = null
                    println("1 -> Add")
                    println("2 -> Update")
                    println("3 -> Delete")
                    println("4 -> Get")
                    println("5 -> Regresar al menú principal :D")
                    println("Ingrese una opción:")
                    var opc: Int = main.readInt()
                    when (opc) {
                        1 -> {
                            val (name, description) = main.readCourse()
                            course = ProgramingCourse(main.idProgramming++, name, description)

                            if (main.programingCourses.add(course)) {
                                println(Main.MSG_SUCCESS)
                            } else println(Main.MSG_ERROR)
                        }
                        2 -> {
                            println("Ingresa el id del curso que deseas actualizar: ")
                            var id = main.readInt()
                            var course = main.programingCourses.get(id)
                            if (course != null) {

                                val (name, description) = main.readCourse()
                                course.name = name
                                course.description = description

                                if (main.programingCourses.update(course)) println(Main.MSG_SUCCESS)
                                else Main.MSG_ERROR
                            } else println(Main.MSG_ERROR)
                        }
                        3 -> {
                            println("Ingresa el id del curso que deseas eliminar: ")
                            var id = main.readInt()

                            if (main.programingCourses.delete(id)) println(Main.MSG_SUCCESS)
                            else Main.MSG_ERROR
                        }
                        4 -> {
                            println("Lista de Cursos de Programación")
                            for (c in main.programingCourses.list)
                                println("${c.id}.- ${c.name} - ${c.description}")
                        }

                        else -> println("Opción inexistente :CCC")
                    }
                } while (opc != 5)
            }
            3 -> {
                println("------------------------Listar todos------------------------")
                println("Lista de Cursos de Cocina")
                for (c in main.cookingCourses.list)
                    println("${c.id}.- ${c.name} - ${c.description}")
                println("Lista de Cursos de Cocina")
                for (c in main.programingCourses.list)
                    println("${c.id}.- ${c.name} - ${c.description}")
            }
            4 -> println("Bye")
            else -> println("Opción Inexistente")
        }
    } while (opc != 4)
}