'use strict';

/**
 * StudentController
 * @constructor
 */
var StudentController = function($scope, $http) {
    $scope.student = {};
    $scope.editMode = false;

    $scope.fetchStudentsList = function() {
        $http.get('students/studentslist.json').success(function(studentList){
            $scope.students = studentList;
        });
    };

    $scope.addNewStudent = function(student) {
        $scope.resetError();

        $http.post('students/addStudent', student).success(function() {
            $scope.fetchStudentsList();
            $scope.student.name = '';
            $scope.student.percentage = '';
            $scope.student.eligible = false;
        }).error(function() {
            $scope.setError('Could not add a new student');
        });
    };

    $scope.updateStudent = function(student) {
        $scope.resetError();

        $http.put('students/updateStudent', student).success(function() {
            $scope.fetchStudentsList();
            $scope.student.name = '';
            $scope.student.percentage = '';
            $scope.student.eligible = false;
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the student');
        });
    };

    $scope.editStudent = function(student) {
        $scope.resetError();
        $scope.student = student;
        $scope.editMode = true;
    };

    $scope.removeStudent = function(id) {
        $scope.resetError();

        $http.delete('students/removeStudent/' + id).success(function() {
            $scope.fetchStudentsList();
        }).error(function() {
            $scope.setError('Could not remove student');
        });
        $scope.student.name = '';
        $scope.student.percentage = '';
    };

    $scope.removeAllStudents = function() {
        $scope.resetError();

        $http.delete('students/removeAllStudents').success(function() {
            $scope.fetchStudentsList();
        }).error(function() {
            $scope.setError('Could not remove all students');
        });

    };

    $scope.resetStudentForm = function() {
        $scope.resetError();
        $scope.student = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchStudentsList();

    $scope.predicate = 'id';
};