const API_URL = "http://localhost:8080/api/surveys";

// Get Survey ID from URL
function getSurveyIdFromUrl() {
    const urlParams = new URLSearchParams(window.location.search);
    const surveyId=urlParams.get("surveyId");
    return Number(surveyId) ;
}


// Load the survey details
function loadSurveyForUpdate() {
    const surveyId = getSurveyIdFromUrl();
    if (!surveyId) {
        alert("Survey ID not found!");
        return;
    }

    fetch(`${API_URL}/${surveyId}`)
        .then(response => response.json())
        .then(survey => {
            document.getElementById("updateTitle").value = survey.title;

            const container = document.getElementById("updateQuestionsContainer");
            container.innerHTML = ""; // Clear old questions

            survey.questions.forEach(question => {
                const input = document.createElement("input");
                input.type = "text";
                input.className = "updateQuestion";
                input.value = question;
                input.required = true;
                container.appendChild(document.createElement("br"));
                container.appendChild(input);
            });

            document.getElementById("updateSurveyForm").onsubmit = function (event) {
                event.preventDefault();
                updateSurvey(surveyId);
            };
        })
        .catch(error => console.error("Error loading survey:", error));
}

// Update Survey API Call
function updateSurvey(id) {
    const title = document.getElementById("updateTitle").value;
    const questions = [...document.querySelectorAll(".updateQuestion")].map(q => q.value);

    fetch(`${API_URL}/update/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ title, questions })
    })
    .then(response => response.json())
    .then(() => {
        alert("Survey Updated!");
        window.location.href = "survey_template.html"; // Redirect back after update
    })
    .catch(error => console.error("Error updating survey:", error));
}


// Add new question field
function addQuestion() {
    const questionContainer = document.getElementById("questionsContainer");
    const input = document.createElement("input");
    input.type = "text";
    input.className = "question";
    input.required = true;
    questionContainer.appendChild(document.createElement("br"));
    questionContainer.appendChild(input);
}


// Load survey data on page load
window.onload = loadSurveyForUpdate;
